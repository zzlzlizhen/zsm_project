package com.zsm.personplay.singleton;

/**
 * created by zsm on 2020/4/27
 * 单例模式的意义，就是希望这个类只有一个实例
 */
public class SingLetonTest {
    public static void main(String[] args) {
        /**
         * 单线程调用
         */
       /* LazySingLeton instance = LazySingLeton.getInstace();
        LazySingLeton instance1 = LazySingLeton.getInstace();
        System.out.println(instance == instance1);*/
        /**
         * 多线程调用
         */
       new Thread(new Runnable() {
           @Override
           public void run() {
               LazySingLeton instance = LazySingLeton.getInstace();
               System.out.println(instance);
           }
       }).start();
       new Thread(new Runnable() {
           @Override
           public void run() {
               LazySingLeton instance2 = LazySingLeton.getInstace();
               System.out.println(instance2);
           }
       }).start();

    }
}
