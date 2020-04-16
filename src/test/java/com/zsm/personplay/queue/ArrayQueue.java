package com.zsm.personplay.queue;

import java.util.Scanner;

/**
 * created by zsm on 2020/3/13
 */
class testArrayQueue{
    public static void main(String[] args) {
        //初始化队列大小
        ArrayQueue queue= new ArrayQueue(3);
        char s = ' ';
        //创建用户输入类
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("输入a,给队列添加一个元素");
            System.out.println("输入q,查询队列中的元素");
            System.out.println("输入g,取出队列中的元素");
            System.out.println("输入h,查询队列的头元素");
            System.out.println("输入e,运行结束");
            s = scanner.next().charAt(0);
            switch (s){
                case 'a':
                    System.out.println("请输入添加到队列的元素");
                    int n = scanner.nextInt();
                    queue.addQueue(n);
                break;
                case 'q':
                    try {
                        queue.queryQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数为:%d",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                       int h = queue.queryHead();
                       System.out.printf("当前的头数据为：%d",h);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
/**
 * 通过数组模拟一个队列
 * 首先队列是先进先出（FIFO）
 * 队列：有头（front=-1），有尾（rear=-1）
 * 队列在加入的时候，头不变，尾增加
 * 对列在取出的时候，尾不变，头增加
 * 都列最大容量为maxSize
 * 当头等于尾的时候证明此时对列没有元素
 * 当尾等于maxSize-1说明该队列已满
 */
public class ArrayQueue {
    private int front; //队列头
    private int rear; //队列尾
    private int maxSize; //队列可以存放的最大值
    private int[] arrQuery; //需要存放队列的一维数组
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arrQuery = new int[maxSize]; //初始化数组模拟的队列
        front = -1;
        rear = -1;
    }
    //判断队列已满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //判断队列为空
    public boolean isEmpety(){
        return front == rear;
    }
    //添加队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能添加元素");
            return;
        }
        arrQuery[++rear] = n;

    }
    //查询当前队列
    public void queryQueue(){
        if(isEmpety()){
            throw new RuntimeException("队列为空，没有数据");
        }
        for (int i = 0; i < maxSize; i++){
            System.out.printf("arr[%d]=%d,",i,arrQuery[i]);
        }
    }
    //取出队列
   public int getQueue(){
       if(isEmpety()){
           throw new RuntimeException("队列为空，没有数据");
       }
       int res = arrQuery[++front];
       return res;
   }
   //查询队列头元素
    public int queryHead(){
        if(isEmpety()){
            throw new RuntimeException("队列为空，没有数据");
        }
       return arrQuery[front + 1];
    }
}
