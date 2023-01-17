package com.bf.algorithm.xiaohui;

/**
 * @description:
 * @author: bofei
 * @date: 2023-01-17 15:51
 **/
public class MyQueue {

    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity){
        this.array = new int[capacity];
    }

    /**
     * 入队
     * @param element  入队的元素
     */
    public void enQueue(int element) throws Exception {
        if((rear+1)%array.length == front){
            throw new Exception("队列已满！");
        }
        array[rear] = element;
        rear =(rear+1)%array.length;
    }

    /**
     * 出队
     */
    public int deQueue() throws Exception {
        if(rear == front){
            throw new Exception("队列已空！");
        }
        int deQueueElement = array[front];
        front =(front+1)%array.length;
        return deQueueElement;
    }

    /**
     * 输出队列
     */
    public void output(){
        for(int i=front; i!=rear; i=(i+1)%array.length){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue(7); // 注意；队尾指针空出1位；front==rear 会被判断是空
        queue.enQueue(3);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(8);
        queue.enQueue(1);
        queue.deQueue();
        queue.enQueue(2);
        queue.enQueue(9);
        queue.deQueue();
        queue.enQueue(11);
        queue.output();
        //  9 11  6  8  1 2  // 6开头
    }
}