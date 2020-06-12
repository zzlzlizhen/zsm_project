package com.zsm.personplay.collection;

/**
 * created by zsm on 2020/5/13
 */
public class SetTest {
    public static void main(String[] args) {
    /*    String s1 = "runoob";
        String s2 = "runoob";
        System.out.println("s1 == s2 is:" + s1 == s2);
*/
     /*   Character character = 'A';
        System.out.println(Character.isLetter(character));
        System.out.println(Character.isDigit(character));
        System.out.println(Character.isWhitespace(character));
        System.out.println(Character.isUpperCase(character));
        System.out.println(Character.isLowerCase(character));
        System.out.println(Character.toUpperCase(character));
        System.out.println(Character.toLowerCase(character));*/
     char[] hh = {'我','是','中','国','人'};
     String str1 = new String(hh);
     System.out.println(str1);
     String str2 = "30";
     String str3 = "80";
     System.out.println(str2.concat(str1));
     System.out.println(str1.charAt(3));
     System.out.println(str3.compareTo(str2));
   /*  float floatVar = 12.09454f;
     int intvar = 193;
     String strVar = "212";
     System.out.printf("浮点型变量的值为" + "%f, 整型变量的值为：" + "%d,字符串变量的值为：" + "is %s\n",floatVar,intvar,strVar);
     String fs;
     fs = String.format("浮点型变量的值为" + "%f, 整型变量的值为：" + "%d,字符串变量的值为：" + "is %s",floatVar,intvar,strVar);
     System.out.println(fs);*/
    }

}
