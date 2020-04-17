package com.zsm.personplay.string;

import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by zsm on 2020/4/17
 */
public class TestString {
    //1.检查字符串中有多少个dog
    //2.检查字符串部分匹配和完全匹配
    //3.把符合“a*b”的字符串替换为-
    //4.把所有的dog替换为cat
    //5，邮箱验证
    //6.字符串跟arraylist互相转换
    public static void main(String[] args) {
        TestString testString = new TestString();
        testString.checkDog();
        testString.checkRex();
        testString.replaceAB();
        testString.replaceDog();
    }
    /**
     * 检查一个字符串中有多少个dog
     */
    public  void checkDog(){
        //原始字符串
        String oldStr = "dogdogdodddddogdddogg";
        //正则表达式
        String regx = "dog";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher  = pattern.matcher(oldStr);
        int count = 0;
        while (matcher.find()){
            count++;

            System.out.println("start:" + matcher.start());
            System.out.println("end:" + matcher.end());

        }
        System.out.println("count:" + count );
    }
    /**
     * 检查字符串完全匹配跟部分匹配
     */
    public void checkRex(){
        String oldStr = "fotrrofooooooooooooooooooo";
        String rexg = "foo";
        String allRex = "fo*";
        Pattern pattern1 = Pattern.compile(rexg);
        Pattern pattern2 = Pattern.compile(allRex);
        Matcher matcher1 = pattern1.matcher(oldStr);
        Matcher matcher2 = pattern2.matcher(oldStr);
        System.out.println("" + matcher1.lookingAt());
        System.out.println(""+ matcher2.lookingAt());
    }
    /**
     * //3.把符合“a*b”的字符串替换为-
     */
    public void replaceAB(){
        String oldStr = "abddddddddddadddbdddabccd";
        String newStr = "";
        String rex = "a*b";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(oldStr);
        while (matcher.find()){
            newStr = matcher.replaceAll("-");
        }
        System.out.println(newStr);
    }
    /**
     * 把所有的dog 替换为cat
     */
    public void replaceDog(){
        String oldStr = "dog is miao cat is eat dog is he";
        String rexg = "dog";
        String newStr = "";
        Pattern pattern = Pattern.compile(rexg);
        Matcher matcher = pattern.matcher(oldStr);
        while (matcher.find()){
            newStr = matcher.replaceAll("cat");
        }
        System.out.println(newStr);
    }
}
