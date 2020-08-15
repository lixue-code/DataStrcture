package com.queue;

public class CircleArrayQueue {
    private int maxSize; //最大容量
    private int rear; //队尾指针,指向最后一个元素的后一位
    private int front; //队头,指向第一个元素
    private int[] arr; //存放数据

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.rear = 0;
        this.front = 0;
        this.arr = new int[maxSize];
    }


    //判断是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //判断是否满
    public boolean isFull(){
        return (rear+1) % maxSize == front;
    }

    //添加元素
    public void addData(int data){
        //判断是否满
        if(isFull()){
            System.out.println("队列已满");
            return;
        }

        arr[rear] = data; //rear本身指向最后一个元素的后一个位置

         rear = (rear+1) % maxSize;
    }


    //取出元素
    public int getData(){
        if(isEmpty()){
            throw  new RuntimeException("队列为空");
        }

        int data = arr[front];
        front = (front+1) % maxSize;
        return data;
    }

    //显示队列
    public void showQueue(){
        if(isEmpty()){
            return;
        }
        System.out.println("队列：");

        //1、 从front开始遍历
        //2、遍历多少个元素
        for (int i = front; i < front+size(); i++) {
            System.out.println("arr["+(i%maxSize)+"]="+arr[i%maxSize]);
        }

    }

    //计算有效元素个数
    public int size(){
        return (rear+maxSize-front) % maxSize;
    }

}
