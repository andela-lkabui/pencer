/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencer.model;

/**
 *
 * @author maina
 */
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import java.sql.SQLException;
import java.util.Vector;

public class QueryTableModel extends AbstractTableModel {

    private int numberOfRows;
    private int numberOfColumns;
    private boolean[] canEdit=null;
    
    private Class[] columnClass;
    private Vector allTheRows;
    private Object[] rowData;
    
    private java.sql.Connection connection=null;
    private java.sql.Statement tableStt=null;
    private java.sql.ResultSet tableRSet=null;
    private java.sql.ResultSetMetaData metaData=null;
    
    public QueryTableModel(java.sql.Connection conn,String query){
        
        connection=conn;
        
        setQuery( query );
        
    }
    
    public Class getColumnClass( int index ){
        
        //return columnClass[index];
        
        Object[] object;
        
        object=(Object[])allTheRows.elementAt(0);
        
        //System.err.println("Column "+index+" = "+object[index].getClass());
        
        return object[index].getClass();
    }
    
    public int getColumnCount(){
    
        return numberOfColumns;
    }
    
    
    public String getColumnName( int column ){

        
        try {
            return metaData.getColumnLabel(column + 1 );
        }
        
        catch ( SQLException sqlException ) {
            JOptionPane.showMessageDialog(null, sqlException,
                    "Error message at QueryTableModel(getColumnName)",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        
        return "";
    }
    
    
    public int getRowCount(){
        return numberOfRows;
    }
    
    
    public Object getValueAt( int row, int column ){
        Object[] obj;
        
        obj=(Object[])allTheRows.elementAt(row);
        
        return obj[column];
    }
    
    public void setValueAt(Object aValue,int row,int column){
        Object[] singleRow;
        singleRow=(Object[])allTheRows.elementAt(row);
        
        singleRow[column]=aValue;
        
        allTheRows.setElementAt(singleRow, row);
        
        this.fireTableCellUpdated(row, column);
        
    }
    

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
       
    }
   
   public void setQuery( String query ){
        try{
            
            tableStt=connection.createStatement();
            tableRSet=tableStt.executeQuery(query);
            metaData=tableRSet.getMetaData();
        
            numberOfColumns=metaData.getColumnCount();
            
            rowData=new Object[numberOfColumns];

//            tableRSet.last();
//
//            numberOfRows = tableRSet.getRow(); 
            
        
            allTheRows=new Vector();
        
//            tableRSet.first();
            
            while(tableRSet.next()){
            
                for(int c=0;c<numberOfColumns;c++){
                    rowData[c]=tableRSet.getObject(c+1);
                }
            
                allTheRows.add(rowData);
            
                rowData=new Object[numberOfColumns];
            
            };
            
            
        }
        catch(SQLException sqle){
            System.err.println("Error at setQuery");
            sqle.printStackTrace();
        }
        
        allTheRows.trimToSize();
        
        numberOfRows=allTheRows.size();
        
        System.err.println("Number of rows is "+numberOfRows);
        
        fireTableStructureChanged();
    }

   public Object getValueAt_OriginalQueryValues(int row,int column){
       
       java.lang.Object objection=null;
       
       try{
           tableRSet.first();
           tableRSet.absolute(row+1);
       
           objection=tableRSet.getObject(column+1);
       }
       catch(java.sql.SQLException sqlw){
           sqlw.printStackTrace();
       }
       
       return objection;

   }
   
   public void setCanEdit(boolean[] editables){
       canEdit=editables;
   }
   
   public void setColumnClass(Class[] classTypes){
       columnClass=classTypes;
   }

}//ends QueryTableModel