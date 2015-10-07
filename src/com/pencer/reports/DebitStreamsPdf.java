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
public class DebitStreamsPdf extends java.lang.Thread{
    
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
            
    public DebitStreamsPdf(java.sql.Connection conn){
        
        connection=conn;
        
        
        
        
        
    }
    
    public void run(){
        
        try{
            
            doc=new com.itextpdf.text.Document();
            doc.setPageSize(com.itextpdf.text.PageSize.A4);
            
            
            sb.deleteCharAt(sb.indexOf(":"));
            sb.deleteCharAt(sb.lastIndexOf(":"));
            
            tempFile=java.io.File.createTempFile("debit_streams"+sb.toString().replace(' ','_'),".pdf");
            tempFile.deleteOnExit();
            
            writer=com.itextpdf.text.pdf.PdfWriter.getInstance(doc,new java.io.FileOutputStream(tempFile));
            writer.setInitialLeading(16);
            
            doc.open();
            
            int columns=3;
            
            table=new com.itextpdf.text.pdf.PdfPTable(columns);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{0.3f, 1.3f, 1.4f});
            table.setHeaderRows(1);
            
            
            doc.add(new com.itextpdf.text.pdf.draw.LineSeparator(10,80,com.itextpdf.text.BaseColor.BLUE,com.itextpdf.text.Element.ALIGN_CENTER,2));
            
            phrase=new Phrase(new Chunk("Debit Streams",reportTitle));
            para=new Paragraph(phrase);
            para.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            
            doc.add(para);
            doc.add(Chunk.NEWLINE);
            
            doc.add(new com.itextpdf.text.pdf.draw.LineSeparator(10,80,com.itextpdf.text.BaseColor.BLUE,com.itextpdf.text.Element.ALIGN_CENTER,2));
            
            doc.add(Chunk.NEWLINE);

            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("No.",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Outlet Name",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Address",colHeader)));
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            table.addCell(cell);
            
            java.sql.Statement stat=connection.createStatement();

            java.sql.ResultSet debitStreamsSet=stat.executeQuery("SELECT description, address FROM service_points " 
                                                        + "ORDER BY description");
            
            int r=1;
            
            while(debitStreamsSet.next()){
                cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(r+"",normal)));
                //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(debitStreamsSet.getString(1),normal)));
                //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
            
                cell=new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(debitStreamsSet.getString(2),normal)));
                //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                r+=1;
            
            }
            
           
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
