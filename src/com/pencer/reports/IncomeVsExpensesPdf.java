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
import com.itextpdf.text.Paragraph;

/**
 *
 * @author maina
 */
public class IncomeVsExpensesPdf extends java.lang.Thread{
    
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
            
    public IncomeVsExpensesPdf(java.sql.Connection conn, java.lang.String bDate, java.lang.String eDate){
        
        connection=conn;
        beginDate=bDate;
        endDate=eDate;
        
        
        
        
    }
    
    public void run(){
        
        System.err.println("IncomeVsExpensesPdf is being generated.");
        
        try{
            
            doc=new com.itextpdf.text.Document();
            doc.setPageSize(com.itextpdf.text.PageSize.A4);
            
            
            sb.deleteCharAt(sb.indexOf(":"));
            sb.deleteCharAt(sb.lastIndexOf(":"));
            
            tempFile=java.io.File.createTempFile("income_vs_expenses_"+sb.toString().replace(' ','_'),".pdf");
            tempFile.deleteOnExit();
            
            writer=com.itextpdf.text.pdf.PdfWriter.getInstance(doc,new java.io.FileOutputStream(tempFile));
            writer.setInitialLeading(16);
            
            doc.open();
            
            int columns=6;
            
            table=new com.itextpdf.text.pdf.PdfPTable(columns);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{0.5f,1f,1.5f,1.0f,0.5f,0.5f});
            
            doc.add(new com.itextpdf.text.pdf.draw.LineSeparator(10,80,com.itextpdf.text.BaseColor.BLUE,com.itextpdf.text.Element.ALIGN_CENTER,2));
            
            phrase=new Phrase(new Chunk("Income Vs Expenses.",reportTitle));
            para=new Paragraph(phrase);
            para.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            
            doc.add(para);
            doc.add(Chunk.NEWLINE);
            
            doc.add(new com.itextpdf.text.pdf.draw.LineSeparator(10,80,com.itextpdf.text.BaseColor.BLUE,com.itextpdf.text.Element.ALIGN_CENTER,2));
            
            doc.add(Chunk.NEWLINE);

            double credit=0.00,debit=0.00,totalAmount=0.00;
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Date",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            //cell.setBorder(com.itextpdf.text.Rectangle.BOTTOM+com.itextpdf.text.Rectangle.TOP);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Revenue/Debit Stream",colHeader)));
            //cell.setColspan(1);
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            cell.setBorder(com.itextpdf.text.Rectangle.BOTTOM);
//            cell.setBorder(com.itextpdf.text.Rectangle.BOTTOM+com.itextpdf.text.Rectangle.TOP);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Credit/ Debit Point",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            //cell.setBorder(com.itextpdf.text.Rectangle.BOTTOM+com.itextpdf.text.Rectangle.TOP);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Description",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            //cell.setBorder(com.itextpdf.text.Rectangle.BOTTOM+com.itextpdf.text.Rectangle.TOP);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Credit",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            cell.setBorder(com.itextpdf.text.Rectangle.BOTTOM);
//            cell.setBorder(com.itextpdf.text.Rectangle.BOTTOM+com.itextpdf.text.Rectangle.TOP);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Debit",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            cell.setBorder(com.itextpdf.text.Rectangle.BOTTOM);
//            cell.setBorder(com.itextpdf.text.Rectangle.BOTTOM+com.itextpdf.text.Rectangle.TOP);
            table.addCell(cell);
            
            java.sql.Statement stat=connection.createStatement();
            
            java.sql.ResultSet incomeVsExpensesSet=stat.executeQuery("SELECT trans_date, bank, creditor_name, description, credit, debit FROM view_of_income_vs_expenses ORDER BY trans_date");
            
            
            int i=1;
                
            while(incomeVsExpensesSet.next()){
                
//                if(i==1){
//                    
//                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(journalSet.getString(1),normal)));
//                    cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
//                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    table.addCell(cell);
//                
//                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(journalSet.getString(2),detailsMob)));
//                    cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT);
//                    table.addCell(cell);
//                
//                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(journalSet.getString(3)+" - "+journalSet.getString(4),detailsMob)));
//                    cell.setColspan(2);
//                    cell.setBorder(com.itextpdf.text.Rectangle.TOP);
//                    table.addCell(cell);
//                
//                    //currency format for monies 
////                    number=nFormatter.parse(journalSet.getString(5));
////                    
////                    System.err.println("nFormatter PARSING RESULTSET = "+nFormatter.parse(journalSet.getString(5)));
////                    System.err.println("nFormatter FORMATTING NUMBER = "+nFormatter.format(number));
//                    
//                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(journalSet.getString(5)),amounts)));
//                    cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
//                    cell.setBorder(com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
//                    table.addCell(cell);
//                    credit+=journalSet.getDouble(5);
//                
//                    //currency format for monies 
////                    number=nFormatter.parse(journalSet.getString(6));
//                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(journalSet.getString(6)),amounts)));
//                    cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
//                    cell.setBorder(com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
//                    table.addCell(cell);
//                    debit+=journalSet.getDouble(6);
//                    
//                }else{
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(incomeVsExpensesSet.getString(1),normal)));
//                    cell.setBorder(com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(incomeVsExpensesSet.getString(2),detailsMob)));
//                    cell.setBorder(com.itextpdf.text.Rectangle.LEFT);
                    table.addCell(cell);
                
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(incomeVsExpensesSet.getString(3),detailsMob)));
//                    cell.setColspan(2);
//                    cell.setBorderColor(BaseColor.WHITE);
                    table.addCell(cell);
                    
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(incomeVsExpensesSet.getString(4),detailsMob)));
//                    cell.setColspan(2);
//                    cell.setBorderColor(BaseColor.WHITE);
                    table.addCell(cell);

                    //currency format for monies 
//                    number=nFormatter.parse(journalSet.getString(5));
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(incomeVsExpensesSet.getString(5)),amounts)));
                    cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
//                    cell.setBorder(com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                    table.addCell(cell);
                    credit+=incomeVsExpensesSet.getDouble(5);
                
                    //currency format for monies 
//                    number=nFormatter.parse(journalSet.getString(6));
                    cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(incomeVsExpensesSet.getString(6)),amounts)));
                    cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
//                    cell.setBorder(com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                    table.addCell(cell);
                    debit+=incomeVsExpensesSet.getDouble(6);
//                }
                
//                i+=1;
                
            }
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Totals Accrued: ",colHeader)));
            cell.setColspan(4);
            //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.BOTTOM);
            table.addCell(cell);
            
            //number=nf.parse(credit+"");
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(credit+""),amounts)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
            //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.BOTTOM);
            table.addCell(cell);
            
            //number=nf.parse(debit+"");
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(debit+""),amounts)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
            //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.BOTTOM);
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
