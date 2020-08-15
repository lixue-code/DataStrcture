package com.test;

import com.queue.ArrayQueue;

public class MainTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addData(10);
        arrayQueue.addData(20);
        arrayQueue.addData(30);

        arrayQueue.showQueue();

        int data = arrayQueue.getData();
        System.out.println("取出的数据："+data);

        arrayQueue.showQueue();

    }
}
