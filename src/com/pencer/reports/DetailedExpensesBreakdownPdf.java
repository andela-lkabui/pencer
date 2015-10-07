/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencer.reports;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;

/**
 *
 * @author maina
 */
public class DetailedExpensesBreakdownPdf extends java.lang.Thread{
    
    private java.util.Date reportDate=new java.util.Date();
    private java.lang.StringBuffer sb=new java.lang.StringBuffer(reportDate.toString());
    private java.io.File tempFile=null;
    private java.sql.Connection connection=null;
    private java.lang.String beginDate=null, endDate=null;
    
    private com.itextpdf.text.Document doc=null;
    private com.itextpdf.text.pdf.PdfWriter writer=null;
    private com.itextpdf.text.pdf.PdfPTable table=null;
    private com.itextpdf.text.pdf.PdfPCell cell=null;
    private Phrase phrase=null;
    private Chunk chunk=null;
    private Paragraph para;
    
    private com.itextpdf.text.Font reportTitle=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,14,com.itextpdf.text.Font.BOLDITALIC+com.itextpdf.text.Font.UNDERLINE);
    private com.itextpdf.text.Font colHeader=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,10,com.itextpdf.text.Font.BOLD);
    private com.itextpdf.text.Font normal=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,8,com.itextpdf.text.Font.NORMAL);
    private com.itextpdf.text.Font detailsMob=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,7,com.itextpdf.text.Font.NORMAL);
    private com.itextpdf.text.Font amounts=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,8,com.itextpdf.text.Font.BOLD);
            
    public DetailedExpensesBreakdownPdf(java.sql.Connection conn, java.lang.String bDate, java.lang.String eDate){
        
        connection=conn;
        beginDate=bDate;
        endDate=eDate;
        
        
        
        
    }
    
    public void run(){
        
        try{
            
            doc=new com.itextpdf.text.Document();
            doc.setPageSize(com.itextpdf.text.PageSize.A4);
            
            
            sb.deleteCharAt(sb.indexOf(":"));
            sb.deleteCharAt(sb.lastIndexOf(":"));
            
            tempFile=java.io.File.createTempFile("detailed_expenses_breakdown"+sb.toString().replace(' ','_'),".pdf");
            tempFile.deleteOnExit();
            
            writer=com.itextpdf.text.pdf.PdfWriter.getInstance(doc,new java.io.FileOutputStream(tempFile));
            writer.setInitialLeading(16);
            
//            BaseFont kacstBase=BaseFont.createFont("/usr/share/fonts/truetype/tlwg/Purisa-Bold.ttf",BaseFont.WINANSI, BaseFont.EMBEDDED);
//            Font normal=new Font(kacstBase, 8);
            
            doc.open();
            
            int columns=6;
            
            table=new com.itextpdf.text.pdf.PdfPTable(columns);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{2.0f,1f,1f,0.5f,0.5f,1f});
            table.setHeaderRows(1);
            
            
            doc.add(new com.itextpdf.text.pdf.draw.LineSeparator(10,80,com.itextpdf.text.BaseColor.BLUE,com.itextpdf.text.Element.ALIGN_CENTER,2));
            
            phrase=new Phrase(new Chunk("Detailed Expenses Breakdown",reportTitle));
            para=new Paragraph(phrase);
            para.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            
            doc.add(para);
            doc.add(Chunk.NEWLINE);
            
            doc.add(new com.itextpdf.text.pdf.draw.LineSeparator(10,80,com.itextpdf.text.BaseColor.BLUE,com.itextpdf.text.Element.ALIGN_CENTER,2));
            
            doc.add(Chunk.NEWLINE);

            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Outlet",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Receipt No.",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Transaction Date",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Qty",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Price",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Totals",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(cell);
            
            java.sql.Statement stat=connection.createStatement();

            java.sql.ResultSet distinctDebitablesSet=stat.executeQuery("SELECT DISTINCT other_foreign_code FROM view_of_expenses_combined "
                                                        + "WHERE buy_date BETWEEN '"+beginDate+"' AND '"+endDate+"' ORDER BY other_foreign_code");
            
            java.sql.Statement detailsStat=connection.createStatement();
            java.sql.ResultSet detailsRs=null;
            
            double hesabu=0.00, grandFinale=0.00;
            
            while(distinctDebitablesSet.next()){
                
                hesabu=0.00;
                
                cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(distinctDebitablesSet.getString(1),colHeader)));
                cell.setColspan(columns);
                cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                detailsRs=detailsStat.executeQuery("SELECT description, receipt_no, buy_date, qty, price, totals FROM view_of_expenses_combined "
                                    + "WHERE other_foreign_code='"+distinctDebitablesSet.getString(1)+"' "
                                    + "AND buy_date BETWEEN '"+beginDate+"' AND '"+endDate+"' ORDER BY buy_date");
                
                while(detailsRs.next()){
                    
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(detailsRs.getString(1),normal)));
                    //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);
                
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(detailsRs.getString(2),normal)));
                    //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(detailsRs.getString(3),normal)));
                    //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);
                
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(detailsRs.getString(4),normal)));
                    //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(detailsRs.getString(5)),normal)));
                    //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell);
                
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(detailsRs.getString(6)),normal)));
                    //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell);
                
                    hesabu+=detailsRs.getDouble(6);
                
                }
                
                cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Total Sum",colHeader)));
                //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setColspan(columns-1);
                table.addCell(cell);
                
                cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(hesabu+""),colHeader)));
                //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);
                
                grandFinale+=hesabu;
            }
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("",colHeader)));
            //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
            cell.setColspan(columns);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Grand Total",colHeader)));
            //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setColspan(columns-1);
            table.addCell(cell);
                
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(grandFinale+""),colHeader)));
            //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);
            
            
           
            doc.add(table);
            
            doc.close();
            
            if(java.awt.Desktop.isDesktopSupported()){
                java.awt.Desktop.getDesktop().open(tempFile);
            }
            else{
                java.lang.Runtime runtime=Runtime.getRuntime();
                
                java.lang.Process launchPdf=runtime.exec("evince "+tempFile+" ");
                
                launchPdf.waitFor();
            }
                
            
        }catch(java.io.IOException ioe){
            ioe.printStackTrace();
        }catch(com.itextpdf.text.DocumentException de){
            de.printStackTrace();
        }catch(java.sql.SQLException sqle){
            sqle.printStackTrace();
        }catch(java.lang.InterruptedException ie){
            ie.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
        
    
}
