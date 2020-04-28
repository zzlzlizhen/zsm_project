package com.zsm.personplay.basetest;

import com.alibaba.druid.sql.visitor.functions.Char;

/**
 * created by zsm on 2020/4/27
 */
public class BaseTest {
    public static void main(String[] args) {
     /*   char a = '3';
        Char c = new Char();
        Character d = a;
        int n = a;
        System.out.println(n);
        double e =  a;
        System.out.println(e);*/
        int i = 128;
        byte b = (byte)i;//-128
        System.out.println(b);

        System.out.println((int)23.7);
        System.out.println((int)-45.89f);
        Integer integer2 = 168;
       int i1 = Integer.parseInt("168");
      // Integer integer = Integer.valueOf(228);
       Integer integer1 = new Integer(168);
       Integer integer = new Integer(168);
      // int i2 = integer.intValue();
       System.out.println(integer == integer1);
       System.out.println(integer1 == integer2);
        System.out.println(integer == i1);
        double d1 = 2.088;
        Double d2 = 2.088;
        System.out.println(d1 == d2);
        Double d3 = new Double(2.088);
        System.out.println(d3==d1);
        System.out.println(d2 == d3);
    }
}
