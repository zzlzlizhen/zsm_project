package com.zsm.personplay.hashmap;

import java.util.HashMap;

/**
 * created by zsm on 2020/3/19
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<String,String>(13);
        hashMap.put("ss","112");
        hashMap.put("aa","234");
        String str = "abcc";
        String str1 = "bbbb";
        System.out.println(str.charAt(1));
        System.out.println(str.codePointAt(0));
        System.out.println(str.codePointBefore(1));
        System.out.println(str.codePointCount(0,2));
        System.out.println(str.compareTo(str1));
    }

}
