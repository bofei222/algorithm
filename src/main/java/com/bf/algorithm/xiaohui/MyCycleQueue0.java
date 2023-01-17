package com.bf.algorithm.xiaohui;

/**
 * @description:
 * @author: bofei
 * @date: 2023-01-17 15:26
 **/


public class MyCycleQueue0 {
    private int front;
    private int rear;
    private int[] arr;

    public MyCycleQueue0(int capacity) {
        this.arr = new int[capacity];
    }

    public void enQueue(int element) throws Exception {
        if (front != 0 && rear == front) {
            throw new Exception("超出长度");
        }

        if (rear == arr.length) {
            rear = 0;
            arr[rear] = element;
        } else if (rear < arr.length){
            arr[rear] = element;
            rear++;  // 这里是先加再赋值
        }

    }
    public void deQueue() {
        front ++;
    }

    public void output() {
        for (int i = front; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        MyCycleQueue0 queue = new MyCycleQueue0(6);
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(8);
        queue.enQueue(1);
        queue.output();
        queue.deQueue();
        queue.enQueue(2);
        queue.enQueue(9);
        queue.deQueue();
        queue.enQueue(11);

    }
}
