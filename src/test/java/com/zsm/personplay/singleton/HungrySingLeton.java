package com.zsm.personplay.singleton;

/**
 * created by zsm on 2020/4/27
 * 饿汉式
 */
public class HungrySingLeton {
    private static HungrySingLeton instance = new HungrySingLeton();
    private  HungrySingLeton(){
    }
    public static HungrySingLeton getInstance(){
        return instance;
    }
}

