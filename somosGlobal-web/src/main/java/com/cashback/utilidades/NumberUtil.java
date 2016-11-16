/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.utilidades;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author somosGlobal
 */
public class NumberUtil {
    
     public static Double round(Double val){
       val= (double) Math.round(val * 100) / 100;
       val = roundDecimal(val,2);
       return val;
    }
    
    public static Double roundDecimal(double initValue, int decimalNumber) {
        double integerPart, result;
        result = initValue;
        integerPart = Math.floor(result);
        result=(result-integerPart)*Math.pow(10, decimalNumber);
        result=Math.round(result);
        result=(result/Math.pow(10, decimalNumber))+integerPart;
        return result;
    }
    
    public static BigDecimal fromDoubleToBigDecimal(Double d){
        BigDecimal result = new BigDecimal(d,MathContext.DECIMAL128);
        result.setScale(2);
        return result;
    }
}
