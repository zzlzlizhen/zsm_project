package com.zsm.personplay.singleton;

import lombok.Synchronized;

/**
 * created by zsm on 2020/4/27
 * 懒汉式
 */
public class LazySingLeton {
    //类变量私有化(volatile防止JIT跟CPU重排序问题)
    private volatile static LazySingLeton instace;
    //构造函数私有化
    private LazySingLeton(){

    }
    //提供一个公共的方式去获取类实例
/*    public static LazySingLeton getInstace() {
        *//**
         * 使用以下方式在单线程方式下也没法保证是单例模式
         *//*
        //instace = new LazySingLeton();
        *//**
         * 在单线程状况下可以保证是单实例，但是在多线程状态下无法保证始终是单实例
         *//*
        if(instace == null){
            instace = new LazySingLeton();
        }
        return instace;
    }*/
    //多线程环境下对单实例进行改造
    public synchronized static LazySingLeton getInstace() {
        if(instace == null){
            synchronized (LazySingLeton.class){
                if(instace == null){
                    instace = new LazySingLeton();
                    //字节码层
                    //分配空间
                    //初始化
                    //引用赋值
                }
            }
        }
        return instace;
    }
}
