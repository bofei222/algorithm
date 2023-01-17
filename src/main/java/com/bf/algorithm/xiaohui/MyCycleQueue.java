package com.bf.algorithm.xiaohui;

/**
 * @description:
 * @author: bofei
 * @date: 2023-01-17 14:10
 **/
public class MyCycleQueue {
    private int front;
    private int rear;
    private int[] arr;

    public MyCycleQueue(int capacity) {
        this.arr = new int[capacity];
    }

    public void enQueue(int element) throws Exception {
        if (front != 0 && rear == front) {
            throw new Exception("超出长度");
        }
        arr[rear % arr.length] = element; // 原答案这里还是 没映射；是直接改变的rear
        rear++;  // 这里是先加再赋值
    }

    public void deQueue() {
        front++;
    }

    public void output() {
        for (int i = front% arr.length; i <= rear%arr.length; i++) {//遍历这里也利用了 取模的特性，慢6（数组长度）归0；直到到结尾rear
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyCycleQueue queue = new MyCycleQueue(6);
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
