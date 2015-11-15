/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencer.reports;

import java.text.SimpleDateFormat;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Font;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;

/**
 *
 * @author maina
 */
public class AverageMonthlyExpenditurePdf extends java.lang.Thread {

    private java.util.Date reportDate = new java.util.Date();
    private java.lang.StringBuffer sb = new java.lang.StringBuffer(reportDate.toString());
    private java.io.File tempFile = null;
    private java.sql.Connection connection = null;
    private java.lang.String beginDate = null, endDate = null;

    private com.itextpdf.text.Document doc = null;
    private com.itextpdf.text.pdf.PdfWriter writer = null;
    private com.itextpdf.text.pdf.PdfPTable tableau = null;
    private com.itextpdf.text.pdf.PdfPCell cell = null;
    private Phrase phrase = null;
    private Chunk chunk = null;
    private Paragraph para;

    private com.itextpdf.text.Font reportTitle = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 14, com.itextpdf.text.Font.BOLDITALIC + com.itextpdf.text.Font.UNDERLINE);
    private com.itextpdf.text.Font colHeader = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 10, com.itextpdf.text.Font.BOLD);
    private com.itextpdf.text.Font normal = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 8, com.itextpdf.text.Font.NORMAL);
    private com.itextpdf.text.Font summedAmount = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 10, com.itextpdf.text.Font.BOLD);
    private com.itextpdf.text.Font amounts = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 8, com.itextpdf.text.Font.BOLD);

    public AverageMonthlyExpenditurePdf(java.sql.Connection conn, java.lang.String begDate, java.lang.String eDate) {

        connection = conn;
        beginDate = begDate;
        endDate = eDate;

    }

    public void run() {

        System.err.println("monthly_expenditure report being generated.");

        try {

            doc = new com.itextpdf.text.Document();
            doc.setPageSize(com.itextpdf.text.PageSize.A4);

            sb.deleteCharAt(sb.indexOf(":"));
            sb.deleteCharAt(sb.lastIndexOf(":"));

            tempFile = java.io.File.createTempFile("average_monthly_expenditure" + sb.toString().replace(' ', '_'), ".pdf");
            tempFile.deleteOnExit();
            
            java.text.SimpleDateFormat simple = new java.text.SimpleDateFormat("E d MMMM YYYY");
                    System.err.println("CMOS Format is " + simple.format(new java.util.Date()));
                    
//            java.text.DateFormat df = java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG);
//            System.err.println("Sam's date is "+df.p("2014-12-02"));

            writer = com.itextpdf.text.pdf.PdfWriter.getInstance(doc, new java.io.FileOutputStream(tempFile));
            writer.setInitialLeading(16);

            doc.open();

            int columns = 4;

            tableau = new com.itextpdf.text.pdf.PdfPTable(columns);
            tableau.setWidthPercentage(100);
            tableau.setWidths(new float[]{2.5f, 0.5f, 0.5f, 0.5f});

            doc.add(new com.itextpdf.text.pdf.draw.LineSeparator(10, 80, com.itextpdf.text.BaseColor.BLUE, com.itextpdf.text.Element.ALIGN_CENTER, 2));

            phrase = new Phrase(new Chunk("Average Monthly Expenditure", reportTitle));
            para = new Paragraph(phrase);
            para.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);

            doc.add(para);
            doc.add(Chunk.NEWLINE);

            doc.add(new com.itextpdf.text.pdf.draw.LineSeparator(10, 80, com.itextpdf.text.BaseColor.BLUE, com.itextpdf.text.Element.ALIGN_CENTER, 2));

            doc.add(Chunk.NEWLINE);

            java.sql.Statement everythingStat = connection.createStatement();

            java.sql.ResultSet everythingSet = everythingStat.executeQuery("SELECT * FROM view_of_expenses_combined "
                    + "WHERE buy_date BETWEEN '" + beginDate + "' AND '" + endDate + "' "
                    + "ORDER BY buy_date ");

            String monthName = null;
            int monthNo = 0, year = 0;
            double totalsPerMonth = 0.00, grandTotal = 0.00;
            //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf = new SimpleDateFormat("MM");
            SimpleDateFormat yrSDF = new SimpleDateFormat("yyyy");

            java.sql.Statement particularsStat = connection.createStatement();
            java.sql.ResultSet particularsSet = null;
            java.util.Vector vector = new java.util.Vector();

            while (everythingSet.next()) {

                if (monthNo == Integer.parseInt(sdf.format(everythingSet.getDate(4)))) {
                    //continue adding items ignore new month

                    for (int i = 0; i < vector.size(); i++) {
                        particularsSet = particularsStat.executeQuery("SELECT sum(qty), avg(price), sum(totals) FROM view_of_expenses_combined "
                                + "WHERE other_foreign_code='" + vector.elementAt(i) + "' "
                                + "AND buy_date BETWEEN '" + beginDate + "' AND '" + endDate + "'");

                        while (particularsSet.next()) {
                            cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(vector.elementAt(i).toString(), normal)));
                            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                            tableau.addCell(cell);

                            cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(particularsSet.getString(1), amounts)));
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            tableau.addCell(cell);

                            cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(particularsSet.getString(2)), amounts)));
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            tableau.addCell(cell);

                            cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(particularsSet.getString(3), amounts)));
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            tableau.addCell(cell);

                            totalsPerMonth += particularsSet.getDouble(3);
                        }

                    }

                    vector = new java.util.Vector();

                } else {

                    if (monthNo != 0) {
                        cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Total Expenditure (" + monthName + ") ", colHeader)));
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setColspan(3);
                        tableau.addCell(cell);

                        cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(totalsPerMonth + ""), summedAmount)));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        tableau.addCell(cell);

                        grandTotal += totalsPerMonth;

                        totalsPerMonth = 0.00;

                        cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(" ")));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setColspan(columns);
                        cell.setBorder(Rectangle.TOP + Rectangle.BOTTOM);
                        tableau.addCell(cell);
                    }

                    //update monthNo
                    monthNo = Integer.parseInt(sdf.format(everythingSet.getDate(4)));
                    year = Integer.parseInt(yrSDF.format(everythingSet.getDate(4)));

                    //proceed to next month
                    switch (monthNo) {
                        case 1:
                            monthName = "January";

                            beginDate = year + "-01-01";
                            endDate = year + "-01-31";

                            break;

                        case 2:
                            monthName = "February";

                            beginDate = year + "-02-01";

                            if (year % 4 == 0) {
                                endDate = year + "-02-29";
                            } else {
                                endDate = year + "-02-28";
                            }
                            
                            break;

                        case 3:

                            monthName = "March";

                            beginDate = year + "-03-01";
                            endDate = year + "-03-31";

                            break;

                        case 4:

                            monthName = "April";

                            beginDate = year + "-04-01";
                            endDate = year + "-04-30";

                            break;

                        case 5:

                            monthName = "May";

                            beginDate = year + "-05-01";
                            endDate = year + "-05-31";

                            break;

                        case 6:

                            monthName = "June";

                            beginDate = year + "-06-01";
                            endDate = year + "-06-30";

                            break;

                        case 7:

                            monthName = "July";

                            beginDate = year + "-07-01";
                            endDate = year + "-07-31";

                            break;

                        case 8:

                            monthName = "August";

                            beginDate = year + "-08-01";
                            endDate = year + "-08-31";

                            break;

                        case 9:

                            monthName = "September";

                            beginDate = year + "-09-01";
                            endDate = year + "-09-30";

                            break;

                        case 10:

                            monthName = "October";

                            beginDate = year + "-10-01";
                            endDate = year + "-10-31";

                            break;

                        case 11:

                            monthName = "November";

                            beginDate = year + "-11-01";
                            endDate = year + "-11-30";

                            break;

                        case 12:

                            monthName = "December";

                            beginDate = year + "-12-01";
                            endDate = year + "-12-31";

                            break;

                        default:
                    }

                    //now the long cell and the columns below it
                    cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(monthName, colHeader)));
                    //cell.setBorder(com.itextpdf.text.Rectangle.TOP+com.itextpdf.text.Rectangle.LEFT+com.itextpdf.text.Rectangle.RIGHT);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell.setColspan(columns);
                    tableau.addCell(cell);

                    cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Item Description", colHeader)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tableau.addCell(cell);

                    cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Qty", colHeader)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tableau.addCell(cell);

                    cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Price", colHeader)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tableau.addCell(cell);

                    cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Total", colHeader)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tableau.addCell(cell);

                    System.err.println("monthName " + monthName);
                    System.err.println("beginDate " + beginDate);
                    System.err.println("endDate " + endDate);

                    particularsSet = particularsStat.executeQuery("SELECT DISTINCT other_foreign_code FROM view_of_expenses_combined "
                            + "WHERE buy_date BETWEEN '" + beginDate + "' AND '" + endDate + "' "
                            + "ORDER BY other_foreign_code");

                    while (particularsSet.next()) {
                        vector.add(particularsSet.getString(1));

                        System.err.println(particularsSet.getString(1) + " bought in " + monthName);
                    }

                    vector.trimToSize();
                    particularsSet = null;
                }

            }//ends everythingSet loop

            //the last month ian't being factored in inside the everything loop.
            cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Total Expenditure (" + monthName + ") ", colHeader)));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setColspan(3);
            tableau.addCell(cell);

            cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(totalsPerMonth + ""), summedAmount)));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tableau.addCell(cell);

            grandTotal += totalsPerMonth;

            totalsPerMonth = 0.00;

            cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(" ")));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setColspan(columns);
            cell.setBorder(Rectangle.TOP + Rectangle.BOTTOM);
            tableau.addCell(cell);

            cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk("Grand Total ", colHeader)));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setColspan(3);
            tableau.addCell(cell);

            cell = new com.itextpdf.text.pdf.PdfPCell(new Phrase(new Chunk(com.pencer.utility.CurrencyFormatter.formatJavaLangNumberToCurrency(grandTotal + ""), summedAmount)));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tableau.addCell(cell);

            doc.add(tableau);

            doc.close();

            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop.getDesktop().open(tempFile);
            } else {
                java.lang.Runtime runtime = Runtime.getRuntime();

                java.lang.Process launchPdf = runtime.exec("evince " + tempFile + " ");

                launchPdf.waitFor();
            }

        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        } catch (com.itextpdf.text.DocumentException de) {
            de.printStackTrace();
        } catch (java.sql.SQLException sqle) {
            sqle.printStackTrace();
        } catch (java.lang.InterruptedException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
