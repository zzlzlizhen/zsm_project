package com.zsm.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * created by zsm on 2020/4/16
 */
public class I18n {
    public static void main(String[] args) {
        Locale localeEn = new Locale("en", "US");

        Locale localeZh = new Locale("zh", "CN");

        ResourceBundle rbEn = ResourceBundle.getBundle("content", localeEn);

        ResourceBundle rbZh = ResourceBundle.getBundle("content", localeZh);

        System.out.println("us-US:" + rbEn.getString("helloWorld"));

        System.out.println("us-US:" + String.format(rbEn.getString("time"), "08:00"));

        System.out.println("zh-CN：" + rbZh.getString("helloWorld"));

        System.out.println("zh-CN：" + String.format(rbZh.getString("time"), "08:00"));
    }
}
