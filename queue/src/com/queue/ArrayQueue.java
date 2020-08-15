package com.queue;

public class ArrayQueue {
    private int maxSize; //最大容量
    private int rear; //队尾指针
    private int font; //队头
    private int[] arr; //存放数据

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.rear = -1;
        this.font = -1;
        this.arr = new int[maxSize];
    }


    //判断是否为空
    public boolean isEmpty(){
        return rear==font;
    }

    //判断是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //添加元素
    public void addData(int data){
        //判断是否满
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = data;
    }


    //取出元素
    public int getData(){
        if(isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        font++;
        int data = arr[font];
        return data;
    }

    //显示队列
    public void showQueue(){
        System.out.print("队列：");
        for (int i : arr) {
            System.out.print(i+"\t");
        }

//        for (int i = arr.length-1; i >=0 ; i--) {
//            System.out.print(arr[i]+"\t");
//        }
    }

}
