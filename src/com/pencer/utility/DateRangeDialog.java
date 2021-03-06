/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencer.utility;

/**
 *
 * @author maina
 */
public class DateRangeDialog extends javax.swing.JDialog {

    private int reportName;
    private java.sql.Connection connection=null;
    
    /**
     * Creates new form DateRangeDialog
     */
    public DateRangeDialog(java.awt.Frame parent, java.sql.Connection conn, int rName) {
        super(parent);
        
        connection=conn;
        reportName=rName;
        
        initComponents();
        
        this.setSize(350, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        motherjPanel = new javax.swing.JPanel();
        buttonjPanel = new javax.swing.JPanel();
        genReportjButton = new javax.swing.JButton();
        closejButton = new javax.swing.JButton();
        beginjPanel = new javax.swing.JPanel();
        beginjButton = new javax.swing.JButton();
        begjTextField = new javax.swing.JTextField();
        endjPanel = new javax.swing.JPanel();
        endjButton = new javax.swing.JButton();
        endjTextField = new javax.swing.JTextField();

        setTitle("Report Date Chooser Dialog");
        setPreferredSize(new java.awt.Dimension(350, 250));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        motherjPanel.setLayout(new java.awt.GridBagLayout());

        buttonjPanel.setLayout(new java.awt.GridBagLayout());

        genReportjButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        genReportjButton.setText("Generate Report");
        genReportjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genReportjButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        buttonjPanel.add(genReportjButton, gridBagConstraints);

        closejButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        closejButton.setText("Close");
        closejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closejButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        buttonjPanel.add(closejButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        motherjPanel.add(buttonjPanel, gridBagConstraints);

        beginjPanel.setLayout(new java.awt.GridBagLayout());

        beginjButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        beginjButton.setText("Set Begin Date");
        beginjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginjButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        beginjPanel.add(beginjButton, gridBagConstraints);

        begjTextField.setEditable(false);
        begjTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 50);
        beginjPanel.add(begjTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        motherjPanel.add(beginjPanel, gridBagConstraints);

        endjPanel.setLayout(new java.awt.GridBagLayout());

        endjButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        endjButton.setText("Set End Date");
        endjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endjButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        endjPanel.add(endjButton, gridBagConstraints);

        endjTextField.setEditable(false);
        endjTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 50);
        endjPanel.add(endjTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        motherjPanel.add(endjPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(motherjPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void endjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endjButtonActionPerformed
        // TODO add your handling code here:
        com.pencer.utility.DatePicker dp=new com.pencer.utility.DatePicker(endjTextField);
    }//GEN-LAST:event_endjButtonActionPerformed

    private void beginjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginjButtonActionPerformed
        // TODO add your handling code here:
        com.pencer.utility.DatePicker dp=new com.pencer.utility.DatePicker(begjTextField);
    }//GEN-LAST:event_beginjButtonActionPerformed

    private void genReportjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genReportjButtonActionPerformed
        // TODO add your handling code here:
        if(begjTextField.getText().length()<1||begjTextField.getText()==null||
                endjTextField.getText()==null||endjTextField.getText().length()<1){
            
            
            javax.swing.JOptionPane.showMessageDialog(this, "Please select both dates first",
                    "Caution Message!",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
        }else{
            
            switch(reportName){
                case 1:
                    com.pencer.reports.CashFlowPdf isummary=new com.pencer.reports.CashFlowPdf(connection, begjTextField.getText(), endjTextField.getText());
                    isummary.start();
                    break;
                
                case 2:
                    com.pencer.reports.ExpensesBreakdownPdf ebreakdown=new com.pencer.reports.ExpensesBreakdownPdf(connection, begjTextField.getText(), endjTextField.getText());
                    ebreakdown.start();
                    break;
                    
                case 3:
                    com.pencer.reports.DetailedExpensesBreakdownPdf dExpensesBreakDown = new com.pencer.reports.DetailedExpensesBreakdownPdf(connection, begjTextField.getText(), endjTextField.getText());
                    dExpensesBreakDown.start();
                    break;
                case 4:
                    com.pencer.reports.IncomeVsExpensesPdf iVsExp = new com.pencer.reports.IncomeVsExpensesPdf(connection, begjTextField.getText(), endjTextField.getText());
                    iVsExp.start();
                    break;
                case 5:
                    com.pencer.reports.AverageMonthlyExpenditurePdf mExRep = new com.pencer.reports.AverageMonthlyExpenditurePdf(connection, begjTextField.getText(), endjTextField.getText());
                    mExRep.start();
                    break;
                
                default:
            }
            
            
            //closejButton.doClick();
        }
        
        
        
    }//GEN-LAST:event_genReportjButtonActionPerformed

    private void closejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closejButtonActionPerformed
        // TODO add your handling code here:
        this.setDefaultCloseOperation(javax.swing.JDialog.DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_closejButtonActionPerformed
   
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DateRangeDialog dialog = new DateRangeDialog(new java.awt.Frame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beginjButton;
    private javax.swing.JPanel beginjPanel;
    private javax.swing.JTextField begjTextField;
    private javax.swing.JPanel buttonjPanel;
    private javax.swing.JButton closejButton;
    private javax.swing.JButton endjButton;
    private javax.swing.JPanel endjPanel;
    private javax.swing.JTextField endjTextField;
    private javax.swing.JButton genReportjButton;
    private javax.swing.JPanel motherjPanel;
    // End of variables declaration//GEN-END:variables
}
