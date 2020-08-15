package com.test;

import com.queue.ArrayQueue;
import com.queue.CircleArrayQueue;
import org.junit.Test;

public class MainTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addData(10);
        arrayQueue.addData(20);
        arrayQueue.addData(30);

        System.out.println("sss");

        arrayQueue.showQueue();

        int data = arrayQueue.getData();
        System.out.println("取出的数据："+data);

        arrayQueue.showQueue();

    }

    //循环队列测试
    @Test
    public void circleQueueTest(){
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        circleArrayQueue.addData(10);
        circleArrayQueue.addData(20);
        circleArrayQueue.addData(30);


        circleArrayQueue.showQueue();
        circleArrayQueue.getData();


        circleArrayQueue.addData(40);
        circleArrayQueue.showQueue();

    }
}
