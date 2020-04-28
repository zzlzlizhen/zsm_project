package com.zsm.personplay.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * created by zsm on 2020/4/27
 */
public class HungrySingLetonTest{
    public static void main(String[] args) {


        //System.out.println(instance == instance2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                HungrySingLeton instance = HungrySingLeton.getInstance();
                System.out.println(instance);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                HungrySingLeton instance2 = HungrySingLeton.getInstance();
                System.out.println(instance2);
            }
        }).start();


        try {
            Constructor<HungrySingLeton> hungryConstructor = HungrySingLeton.class.getDeclaredConstructor();
            hungryConstructor.setAccessible(true);
            HungrySingLeton hungrySingLeton = hungryConstructor.newInstance();
            HungrySingLeton hungrySingLeton1 = HungrySingLeton.getInstance();
            System.out.println(hungrySingLeton == hungrySingLeton1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
