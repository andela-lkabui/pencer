/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencer.debit.expenses;

/**
 *
 * @author maina
 */
public class EditBilledGoods extends javax.swing.JInternalFrame {

    private java.sql.Connection connection=null;
    private javax.swing.JDesktopPane desktopPane=null;
    private com.pencer.search.SearchDialog sd=null;
    private com.pencer.model.QueryTableModel qtm=null;
    private int selectedColumn=-1;
    
    /**
     * Creates new form BillGoods
     */
    public EditBilledGoods(java.sql.Connection conn, javax.swing.JDesktopPane jdp) {
        
        connection=conn;
        desktopPane=jdp;
        
        desktopPane.add(this);
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        totalsjPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalsjTextField1 = new javax.swing.JTextField();
        receiptjPanel = new javax.swing.JPanel();
        datejTextField = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        buttonjPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Edit Billed Goods");
        setPreferredSize(new java.awt.Dimension(732, 600));
        setVisible(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mother Panel"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        tablePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablePanel.setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setToolTipText("");
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        tablePanel.add(jScrollPane1, gridBagConstraints);

        totalsjPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tibetan Machine Uni", 1, 15)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setText("Running Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 267, 0, 100);
        totalsjPanel.add(jLabel1, gridBagConstraints);

        totalsjTextField1.setEditable(false);
        totalsjTextField1.setColumns(10);
        totalsjTextField1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        totalsjTextField1.setForeground(java.awt.Color.red);
        totalsjTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        totalsjPanel.add(totalsjTextField1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        tablePanel.add(totalsjPanel, gridBagConstraints);

        datejTextField.setEditable(false);
        datejTextField.setColumns(10);
        datejTextField.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        jButton6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton6.setText("Set Entry Date");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receiptjPanelLayout = new javax.swing.GroupLayout(receiptjPanel);
        receiptjPanel.setLayout(receiptjPanelLayout);
        receiptjPanelLayout.setHorizontalGroup(
            receiptjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(receiptjPanelLayout.createSequentialGroup()
                .addContainerGap(392, Short.MAX_VALUE)
                .addComponent(datejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(56, 56, 56))
        );
        receiptjPanelLayout.setVerticalGroup(
            receiptjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receiptjPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(receiptjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        tablePanel.add(receiptjPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(tablePanel, gridBagConstraints);

        buttonjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("actionPanel"));
        buttonjPanel.setLayout(new java.awt.GridBagLayout());

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton1.setText("Update Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        buttonjPanel.add(jButton1, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton2.setText("Clear Everything");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        buttonjPanel.add(jButton2, gridBagConstraints);

        jButton3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        buttonjPanel.add(jButton3, gridBagConstraints);

        jButton5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton5.setText("Remove Row");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        buttonjPanel.add(jButton5, gridBagConstraints);

        jButton7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton7.setText("Show Table Details");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        buttonjPanel.add(jButton7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(buttonjPanel, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        qtm=new com.pencer.model.QueryTableModel(connection, "SELECT item_description FROM goods WHERE item_description='DIDIER DROGBA'");
       
        jTable1.setModel(qtm);
        
//        outletjTextField.setText("");
//        datejTextField.setText("");
//        receiptjTextField.setText("");
//        
        calculateTableTotals();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int row=jTable1.getSelectedRow();
        
        for(int c=0;c<jTable1.getColumnCount();c++){
            jTable1.setValueAt(null, row, c);
        }
        
        calculateTableTotals();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        selectedColumn=jTable1.getSelectedColumn();
        
        if(datejTextField.getText()==null||datejTextField.getText().length()<1){
            
            javax.swing.JOptionPane.showMessageDialog(this, "Please first set the date for the entry you want to edit!",
                    "Error Message!",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            
        }else{
            
            if(jTable1.getSelectedColumn()==1){
            
                sd=new com.pencer.search.SearchDialog(true, connection, "SELECT code, description FROM service_points ",
                                                    " WHERE description LIKE '%",
                                                    "%' ORDER BY description");
            
                sd.addSearchDialogListener(new javax.swing.event.ListSelectionListener(){
                    int selectedIndex=-1;
                
                    public void valueChanged(javax.swing.event.ListSelectionEvent lse){
                    
                        selectedIndex=sd.getSearchJTable().getSelectionModel().getMinSelectionIndex();
                    
                        java.lang.Object description=sd.getSearchJTable().getValueAt(selectedIndex, 1);
                    
                        jTable1.setValueAt(description, jTable1.getSelectedRow(), 1);
                        
                        sd.dispose();
                    }
                });
            
                sd.setVisible(true);
                        
            }else if(jTable1.getSelectedColumn()==4){
            
                sd=new com.pencer.search.SearchDialog(true, connection, "SELECT code, item_description, price FROM goods ",
                                                    " WHERE item_description LIKE '%",
                                                    "%' ORDER BY item_description");
            
                sd.addSearchDialogListener(new javax.swing.event.ListSelectionListener(){
                    int selectedIndex=-1;
                
                    public void valueChanged(javax.swing.event.ListSelectionEvent lse){
                        
                        selectedIndex=sd.getSearchJTable().getSelectionModel().getMinSelectionIndex();
                    
                        java.lang.Object description=sd.getSearchJTable().getValueAt(selectedIndex, 1);
                        java.lang.Object price=sd.getSearchJTable().getValueAt(selectedIndex, 2);
                    
                        jTable1.setValueAt(description, jTable1.getSelectedRow(), 4);
                        //jTable1.setValueAt(price, jTable1.getSelectedRow(), 6);
                        
                        sd.dispose();
                    }
                });
            
                sd.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        int row=jTable1.getSelectedRow();
            if(jTable1.getValueAt(row, 5)==null){
                jTable1.setValueAt(calculateValue(0, 0), row, 7);
                
                System.err.println("Ng'ombe 1 has executed");
                
                calculateTableTotals();
                
            } else if(jTable1.getValueAt(row, 6)==null){
                jTable1.setValueAt(calculateValue(0, 0), row, 7);
                
                System.err.println("Ng'ombe 2 has executed");
                
                calculateTableTotals();
                
            }else{
                double qty=Double.parseDouble(jTable1.getValueAt(row, 5)+"");
                double price=(double)jTable1.getValueAt(row, 6);
                
                System.err.println("getValueAT("+row+", 7) before adjustment is = "+jTable1.getValueAt(row, 7));
            
                jTable1.setValueAt(calculateValue(qty, price), row, 7);
                
                System.err.println("getValueAT("+row+", 7) after adjustment is = "+jTable1.getValueAt(row, 7));
                
                System.err.println("Ng'ombe 3 has executed");
                
                calculateTableTotals();
            }
            
        
        
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        com.pencer.utility.DatePicker dp=new com.pencer.utility.DatePicker(datejTextField);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(datejTextField.getText()==null||datejTextField.getText().length()<1){
            javax.swing.JOptionPane.showMessageDialog(this, "The Date of Purchase must be specified.",
                    "Date Missing.",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        
        }else{
            boolean rowComplete=true;
            
            for(int r=0;r<jTable1.getRowCount();r++){
                for(int c=0;c<jTable1.getColumnCount();c++){
                
                    if(!(jTable1.getValueAt(r, 1)==null)){
                        if(jTable1.getValueAt(r, c)==null){
                            rowComplete=false;
                        }
                    }
                    
                }
            }
            
            System.err.println("row complete is "+rowComplete);
            
            if(rowComplete){
                
                java.lang.Object tableValue=null, dbValue=null,a=null;
                
                try{
                    connection.setAutoCommit(false);
                    
                    java.sql.PreparedStatement updatePs=connection.prepareStatement("UPDATE goods_bought SET outlet_code=?, buy_date=?, item_code=?, qty=?, price=? WHERE row_id=?");
                    java.sql.Statement stat=connection.createStatement();
                    java.sql.ResultSet extrasSet=null;
                    
                    for(int r=0;r<jTable1.getRowCount();r++){
                        for(int c=0;c<jTable1.getColumnCount();c++){
                            tableValue=jTable1.getModel().getValueAt(r, c);
                            dbValue=qtm.getValueAt_OriginalQueryValues(r, c);
                            
                            if(!tableValue.equals(dbValue)){
                                //if value you're seeing isn't the same as what is on the db, then it has been edited.
                                //save only what's edited
                                
                                //outlet_code
                                extrasSet=stat.executeQuery("SELECT code FROM service_points WHERE description='"+jTable1.getValueAt(r, 1)+"'");
                                while(extrasSet.next()){
                                    a=extrasSet.getObject(1);
                                }
                                updatePs.setObject(1, a);
                                updatePs.setObject(2, jTable1.getValueAt(r, 3));
                                
//                                System.err.println("Code = "+a);
//                                System.err.println("Buy Date = "+jTable1.getValueAt(r, 3));
                                
                                //item_code
                                extrasSet=stat.executeQuery("SELECT code FROM goods WHERE item_description='"+jTable1.getValueAt(r, 4)+"'");
                                while(extrasSet.next()){
                                    a=extrasSet.getObject(1);
                                }
                                updatePs.setObject(3, a);
                                updatePs.setObject(4, jTable1.getValueAt(r, 5));
                                updatePs.setObject(5, jTable1.getValueAt(r, 6));
                                updatePs.setObject(6, jTable1.getValueAt(r, 0));
                                
//                                System.err.println("Item Code = "+a);
//                                System.err.println("Qty = "+jTable1.getValueAt(r, 5));
//                                System.err.println("Price = "+jTable1.getValueAt(r, 6));
                               
                                
                            }
                        }
                            
                    }
                    
                    updatePs.executeUpdate();
                    
                    connection.commit();
                    connection.setAutoCommit(true);
                
                    javax.swing.JOptionPane.showMessageDialog(this, "Receipt Data Updated!",
                        "Update Successful.",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);

                
                    jButton2.doClick();
                
                }catch(java.sql.SQLException sqle){
                    System.err.println("Error commiting.");
                    sqle.printStackTrace();
                    
                    try{
                    
                        connection.rollback();
                        connection.setAutoCommit(true);
                    
                    }catch(java.sql.SQLException sqlex){
                        System.err.println("Error rolling back.");
                        sqlex.printStackTrace();
                    }
                }
            
            
            }else{
                javax.swing.JOptionPane.showMessageDialog(this, "Please ensure all the rows are filled to completion \n"
                        + "before attempting to save",
                        "Error Message.",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
            
                
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(datejTextField.getText()==null||datejTextField.getText().length()<1){
            
            javax.swing.JOptionPane.showMessageDialog(this, "Please first set the date for the entry you want to edit!",
                    "Error Message!",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            
        }else{
            
            qtm=new com.pencer.model.QueryTableModel(connection, "SELECT row_id,service_points.description, receipt_no, buy_date, goods.item_description, qty, goods_bought.price, totals FROM goods_bought "
                    + "INNER JOIN service_points ON goods_bought.outlet_code=service_points.code INNER JOIN goods ON goods_bought.item_code=goods.code WHERE buy_date='"+datejTextField.getText()+"' "
                    + "ORDER BY goods.item_description");
                
            qtm.setCanEdit(new boolean[]{false, false, true, false, false, true, true, false});
                
            jTable1.setModel(qtm);
                
            calculateTableTotals();
                
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    public double calculateTableTotals(){
        double total=0.00;
        java.text.DecimalFormat df=new java.text.DecimalFormat("0.00");
        
        for(int r=0;r<jTable1.getRowCount();r++){
            
            if(jTable1.getValueAt(r, 1)==null){
                
            }
            else{
                total+=(double)jTable1.getValueAt(r, 7);
            }
            
        }
        
        totalsjTextField1.setText(df.format(total));
        
        return total;
    }
    
    public double calculateValue(double qty, double price){
        return qty*price;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonjPanel;
    private javax.swing.JTextField datejTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel receiptjPanel;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JPanel totalsjPanel;
    private javax.swing.JTextField totalsjTextField1;
    // End of variables declaration//GEN-END:variables
}
