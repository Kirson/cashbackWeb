/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashback.ejb.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author somosGlobal
 */
public class TracingInterceptor {
    
    @AroundInvoke
    public Object logCall(InvocationContext context) throws Exception{
        System.out.println("Invoking method: " + context.getMethod());
        return context.proceed();
    }
}
