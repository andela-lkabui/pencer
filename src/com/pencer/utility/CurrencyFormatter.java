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
public abstract class CurrencyFormatter {
    
    
    public static java.lang.String formatJavaLangNumberToCurrency(String toBeFormatted) throws java.text.ParseException{
        
        java.text.DecimalFormat formatter=(java.text.DecimalFormat) java.text.NumberFormat.getNumberInstance(); 
        
        formatter.setMinimumFractionDigits(2);
        
        formatter.setMaximumFractionDigits(2);
            
        java.lang.Number number=null;
        
        number=formatter.parse(toBeFormatted);
        
        return formatter.format(number);
        
    }
}
