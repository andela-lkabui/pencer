/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencer.reports;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Element;

/**
 *
 * @author maina
 */
public class ExpensesBreakdownPdf extends java.lang.Thread{
    
    private java.util.Date reportDate=new java.util.Date();
    private java.lang.StringBuffer sb=new java.lang.StringBuffer(reportDate.toString());
    private java.io.File tempFile=null;
    private java.sql.Connection connection=null;
    private java.lang.String beginDate=null, endDate=null;
    private java.util.Vector vector=null;
    
    private com.itextpdf.text.Document doc=null;
    private com.itextpdf.text.pdf.PdfWriter writer=null;
    private PdfPTable table=null;
    private PdfPCell cell=null;
    private Phrase phrase=null;
    private Chunk chunk=null;
    private Paragraph para;
    
    private com.itextpdf.text.Font reportTitle=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,14,com.itextpdf.text.Font.BOLDITALIC);//+com.itextpdf.text.Font.UNDERLINE);
    private com.itextpdf.text.Font subTitle=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,7,com.itextpdf.text.Font.ITALIC+com.itextpdf.text.Font.UNDERLINE);
    private com.itextpdf.text.Font colHeader=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,10,com.itextpdf.text.Font.BOLD);
    private com.itextpdf.text.Font normal=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,8,com.itextpdf.text.Font.NORMAL);
    private com.itextpdf.text.Font amounts=new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA,8,com.itextpdf.text.Font.BOLD);
            
    public ExpensesBreakdownPdf(java.sql.Connection conn, java.lang.String bDate, java.lang.String eDate){
        
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
            
            tempFile=java.io.File.createTempFile("expenses_breakdown_"+sb.toString().replace(' ','_'),".pdf");
            tempFile.deleteOnExit();
            
            writer=com.itextpdf.text.pdf.PdfWriter.getInstance(doc,new java.io.FileOutputStream(tempFile));
            writer.setInitialLeading(16);
            
            doc.open();
            
            doc.add(new com.itextpdf.text.pdf.draw.LineSeparator(10,80,com.itextpdf.text.BaseColor.BLUE,com.itextpdf.text.Element.ALIGN_CENTER,2));
            
            phrase=new Phrase(new Chunk("Expenses Breakdown",reportTitle));
            para=new Paragraph(phrase);
            para.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(para);
            //doc.add(Chunk.NEWLINE);
            
            phrase=new Phrase(new Chunk("Dates between "+beginDate+" and "+endDate,subTitle));
            para=new Paragraph(phrase);
            para.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(para);
            //doc.add(Chunk.NEWLINE);
            
            doc.add(Chunk.NEWLINE);
            doc.add(new com.itextpdf.text.pdf.draw.LineSeparator(10,80,com.itextpdf.text.BaseColor.BLUE,com.itextpdf.text.Element.ALIGN_CENTER,2));
            
            doc.add(Chunk.NEWLINE);
            
            table=new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{0.3f,2.2f,0.5f});
            
            cell=new PdfPCell(new Phrase(new Chunk("No.",colHeader)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
                
            cell=new PdfPCell(new Phrase(new Chunk("Expense Description ",colHeader)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
                
            cell=new PdfPCell(new Phrase(new Chunk("Amount",colHeader)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            
            java.sql.Statement distStt=connection.createStatement();
            java.sql.ResultSet distRset=distStt.executeQuery("SELECT DISTINCT other_foreign_code FROM view_of_expenses_combined "
                                                            + "WHERE buy_date BETWEEN '" + beginDate + "' AND '" + endDate + "' ORDER BY 1");
            vector=new java.util.Vector();
            
            while(distRset.next()){
                vector.add(distRset.getString(1));
            }
            
            vector.trimToSize();
            distRset.close();
            distStt.close();
            double totals=0.00;
            
            Object[][] sorterUtility=new Object[vector.size()][2];
            
            distStt=connection.createStatement();
            
            int vLength = vector.size();
            
            for(int ind=0; ind<vLength; ind++){
                distRset=distStt.executeQuery("SELECT SUM(totals) FROM view_of_expenses_combined WHERE other_foreign_code='"+vector.elementAt(ind)+"' AND buy_date BETWEEN '"+beginDate+"' AND '"+endDate+"'");
                
                while(distRset.next()){
                    if(distRset.getString(1)==null){
                        totals=0.00;
                    }else{
                        totals=distRset.getDouble(1);
                    }
                }
                
                sorterUtility[ind][0]=vector.elementAt(ind);
                sorterUtility[ind][1]=totals;
            }
            
            
            /* SORT ALGORITHM
            
            2 dimensional array holding desc and amount
            
            enter loop through all the items in array
            
            compare first 2 values in second index
            if(value1 is lesser than value 2)
                move value 1 to container(swapArray)
                move value 2 to value 1's former position
                move value 1 from container to value 2's former position*/
            
                    
            Object[][] swapArray=new Object[1][2];
            double val1=0.00,val2=0.00;
            
            //sort by totals descending (bubble sort technique)
            for(int iterate=0;iterate<vector.size();iterate++){
                
                for(int pass=0,sentinel=1;pass<vector.size()-1;pass++,sentinel++){
                
                    val1=(double)sorterUtility[pass][1];
                    val2=(double)sorterUtility[sentinel][1];
                
                    if(val1<val2){
                        swapArray[0][0]=sorterUtility[pass][0];
                        swapArray[0][1]=sorterUtility[pass][1];
                    
                        sorterUtility[pass][0]=sorterUtility[sentinel][0];
                        sorterUtility[pass][1]=sorterUtility[sentinel][1];
                    
                        sorterUtility[sentinel][0]=swapArray[0][0];
                        sorterUtility[sentinel][1]=swapArray[0][1];
                    }
                }
                
            }
            
            totals=0.00;
            
            for(int i=0;i<sorterUtility.length;i++){
                cell=new PdfPCell(new Phrase(new Chunk(i+1+"",normal)));
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell=new PdfPCell(new Phrase(new Chunk(sorterUtility[i][0].toString(),normal)));
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell=new PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(sorterUtility[i][1].toString()),amounts)));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);
                
                totals+=(double)sorterUtility[i][1];
            }
            
            cell=new PdfPCell(new Phrase(new Chunk("Total Expenses: ",colHeader)));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setColspan(2);
            table.addCell(cell);
            
            cell=new PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(totals+""),amounts)));
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
    
    public java.util.Vector getDistinctExpenses() throws java.sql.SQLException{
        
        java.sql.Statement stat=connection.createStatement();
        
        java.sql.ResultSet rset=stat.executeQuery("SELECT DISTINCT service_description FROM services UNION SELECT DISTINCT item_description FROM goods ORDER BY 1");
        
        vector=new java.util.Vector();
        
        while(rset.next()){
            vector.add(rset.getString(1));
        }
        
        vector.trimToSize();
        
        System.err.println("Here at distinct expenses?");
        System.err.println("Vector size = "+vector.size());
        
        return vector;
    }
        
    
}
