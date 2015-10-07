/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pencer.utility;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author maina
 */
public class DatePicker extends JDialog{
    
    private JButton[] dates=new JButton[49];
    private String days[]={"S","M","T","W","T","F","S"};
    private JPanel centrePanel=new JPanel();
    private JPanel southPanel=new JPanel();
    private JTextField datePickerTextField;
    private JComboBox monthBox,yearBox;
    private String months[]={"January","February","March","April","May","June",
                             "July","August","September","October","November","December"};
    private Calendar dateLeo=Calendar.getInstance();
    private int year=Calendar.getInstance().get(Calendar.YEAR);
    private int month=Calendar.getInstance().get(Calendar.MONTH);
    private int lowestValue=year-30;
    private int highestValue=year+30;
    private String pickMe="";
    
    
    
    public DatePicker(JTextField textField){
        this.setTitle("Pencer Date Picker");
        System.err.println("Snare 1");
        this.setLayout(new BorderLayout());
        centrePanel.setLayout(new GridLayout(7,7));
        
        datePickerTextField=textField;
        
        System.err.println("Snare 2");
        //INITIALIZING THE COMBO BOXES TO AVOID NULL POINTER EXCEPTIONS
        monthBox=new JComboBox(months);
        monthBox.setSelectedIndex(month);
        
        //int yr=Calendar.getInstance().get(Calendar.YEAR);
        //System.out.println("The year is "+yr);
        
        
        
        String[] yearArray=new String[60];
        //System.out.println("yearArray created");
        
        for (int i=lowestValue,index=0;i<highestValue;i++,index++){
            
            System.out.println("The value of i is "+i+" ("+index+")");
            yearArray[index]=i+"";
            
        }
        
        
        ////////////////////////////////////////////////////////////
        
        for(int i=0;i<dates.length;i++){
            if (i<=6){
                dates[i]=new JButton(days[i]);
                centrePanel.add(dates[i]);
            }
            else{
                dates[i]=new JButton();
                centrePanel.add(dates[i]);
            }
            
        }
        
        //REGISTER ACTION LISTENERS ONLY FOR THE DATE BUTTONS
        for(int i=0;i<dates.length;i++){
            
            if (i>=7){
                final int alIndex=i;
                dates[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        pickMe=dates[alIndex].getActionCommand();
                        datePicked(pickMe,(monthBox.getSelectedIndex()),(yearBox.getSelectedIndex()+lowestValue),datePickerTextField);
                        disposeDatePicker();
                    }
                });
            }
        }
        
        
        //System.out.println("MONTH, YEAR "+month+", "+year);
        //System.out.println("day of week, days in month "+dayOfWeek+", "+daysInMonth);
        
        //displayDate(month,year);
        
        this.add(centrePanel,BorderLayout.CENTER);
        
        
        monthBox.addItemListener(new ItemListener(){
            int mth=Calendar.getInstance().get(Calendar.MONTH);
            public void itemStateChanged(ItemEvent ie){
                displayDate((monthBox.getSelectedIndex()),(yearBox.getSelectedIndex()+lowestValue));
                
            }
        });
        
        
        southPanel.setLayout(new FlowLayout());
        southPanel.add(new JLabel("Month"));
        southPanel.add(monthBox);
        
        southPanel.add(new JLabel("Year"));
        
        
        
        System.out.println("After the loop...");
        yearBox=new JComboBox(yearArray);
        yearBox.setSelectedIndex(30);
        yearBox.addItemListener(new ItemListener(){
            int mwaka=Calendar.getInstance().get(Calendar.YEAR);
            public void itemStateChanged(ItemEvent ie){
                displayDate((monthBox.getSelectedIndex()),(yearBox.getSelectedIndex()+lowestValue));
                System.out.println("yearBox's selected index is "+(yearBox.getSelectedIndex()+lowestValue));
                //yearBox.getSelectedIndex();
            }
        });
        
        southPanel.add(yearBox);
        
        displayDate(monthBox.getSelectedIndex(),Integer.parseInt(yearBox.getSelectedItem().toString()));
        
        this.add(southPanel,BorderLayout.SOUTH);
        
        
        this.setSize(360,200);
        this.setVisible(true);
        //this.setModal(true);
        this.setAlwaysOnTop(true);
        this.pack();
        this.setLocationRelativeTo(datePickerTextField);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public void initialize(){
        for(int i=7;i<dates.length;i++){
            dates[i].setText("");
            
        }
    }
    
    public void displayDate(int mwezi,int year){
        //int month=Calendar.getInstance().get(Calendar.MONTH);
        
        initialize();
        //int year=Calendar.getInstance().get(Calendar.YEAR);
        dateLeo.set(year, mwezi,1);
        
        int dayOfWeek = dateLeo.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = dateLeo.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        for(int i=6+dayOfWeek,tarehe=1;tarehe<=daysInMonth;i++,tarehe++){
            dates[i].setText(tarehe+"");
            //centrePanel.add(dates[i]);
            
        }
    }
    
    public void datePicked(String tarehe,int mwezi,int year,JTextField dateField){
        //if (tarehe.equals("")) return tarehe;
        if(tarehe.equals("")){
            JOptionPane.showMessageDialog(null, "Please select a valid date", 
                    "Invalid date selection",JOptionPane.ERROR_MESSAGE);
        }
        else{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar pickedDate=Calendar.getInstance();
            pickedDate.set(year, mwezi, Integer.parseInt(tarehe));
        
            System.out.println("Picked date = "+sdf.format(pickedDate.getTime()));
        
            dateField.setText(sdf.format(pickedDate.getTime()));
        }
        
    }
    
    public void disposeDatePicker(){
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.dispose();
    }
    
    
}
