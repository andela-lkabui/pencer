/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencer.credit.creditor;

/**
 *
 * @author maina
 */
public class CreateCreditor extends javax.swing.JInternalFrame {

    private javax.swing.JDesktopPane desktopPane=null;
    private java.sql.Connection connection=null;
    private java.lang.String address="P. O. BOX ";
           
    /**
     * Creates new form AddIncome
     */
    public CreateCreditor(java.sql.Connection conn,javax.swing.JDesktopPane jdp) {
        
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
        jPanel2 = new javax.swing.JPanel();
        credNamejTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        credAddrjTextField2 = new javax.swing.JTextField();
        relationjTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        clearjButton = new javax.swing.JButton();
        closejButton = new javax.swing.JButton();
        createjButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Create Creditor");
        setPreferredSize(new java.awt.Dimension(700, 310));
        setVisible(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridBagLayout());

        credNamejTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 0);
        jPanel2.add(credNamejTextField, gridBagConstraints);

        jLabel1.setText("Creditor Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Creditor Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Relation");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        credAddrjTextField2.setColumns(10);
        credAddrjTextField2.setText(address);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 0);
        jPanel2.add(credAddrjTextField2, gridBagConstraints);

        relationjTextField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 0);
        jPanel2.add(relationjTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.GridBagLayout());

        clearjButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        clearjButton.setText("Clear Fields");
        clearjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearjButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        jPanel3.add(clearjButton, gridBagConstraints);

        closejButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        closejButton.setText("Close");
        closejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closejButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel3.add(closejButton, gridBagConstraints);

        createjButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        createjButton.setText("Create Creditor");
        createjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createjButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 12);
        jPanel3.add(createjButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jPanel1.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearjButtonActionPerformed
        // TODO add your handling code here:
        credAddrjTextField2.setText(address);
        credNamejTextField.setText("");
        relationjTextField.setText("");
        
    }//GEN-LAST:event_clearjButtonActionPerformed

    private void createjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createjButtonActionPerformed
        // TODO add your handling code here:
        if(credAddrjTextField2.getText().equalsIgnoreCase(address)||
                credNamejTextField.getText()==null||credNamejTextField.getText().length()<1||
                relationjTextField.getText()==null||relationjTextField.getText().length()<1){
            
            javax.swing.JOptionPane.showMessageDialog(this, "Please ensure all the fields have valid data!",
                    "Error on Save!",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            
        }else{
            
            try{
                
                connection.setAutoCommit(false);
                
                java.sql.PreparedStatement savePs=connection.prepareStatement("INSERT INTO creditors (creditor_name, address, relation) "
                                                                            + "VALUES (?,?,?)");
                savePs.setString(1, credNamejTextField.getText());
                savePs.setString(2, credAddrjTextField2.getText());
                savePs.setString(3, relationjTextField.getText());
                
                savePs.executeUpdate();
                
                connection.commit();
                connection.setAutoCommit(true);
                
                javax.swing.JOptionPane.showMessageDialog(this, "New Creditor Created!",
                    "Insert Successful!",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
                
                clearjButton.doClick();
                
            }catch(java.sql.SQLException sqle){
                System.err.println("Commit error!");
                
                sqle.printStackTrace();
                
                try{
                    connection.rollback();
                    connection.setAutoCommit(true);
                    
                }catch(java.sql.SQLException sqlex){
                    System.err.println("Rollback error!");
                    
                    sqlex.printStackTrace();
                    
                }
            }
                
        }
    }//GEN-LAST:event_createjButtonActionPerformed

    private void closejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closejButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closejButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearjButton;
    private javax.swing.JButton closejButton;
    private javax.swing.JButton createjButton;
    private javax.swing.JTextField credAddrjTextField2;
    private javax.swing.JTextField credNamejTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField relationjTextField;
    // End of variables declaration//GEN-END:variables
}