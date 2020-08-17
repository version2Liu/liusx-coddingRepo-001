package com.liusx.sword.august;

import java.util.Stack;

/**
 * description: QueueImplement <br>
 * date: 2020/8/17 10:15 <br>
 * 用两个栈来实现一个队列，完成队列的Push 和 Pop操作。队列中的元素类型为int
 * @author: liusx <br>
 * version: 1.0 <br>
 */
public class QueueImplement {
    /*
    * 分析：该题重点是了解队列和栈的特点
    *       队列是FIFO 先进先出
    *       栈是  FILO 先进后出
    *   所以这个题就是考察栈的运用
    * */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //注意此处是，只要stack2是空的了，就需要架构stack1中的值倒腾到stack2中
        if(stack2.empty()){
            //如果是空的，就遍历Stack1,将stack1的值填入Stack2中
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        //最后返回stack2的弹栈
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueImplement qu = new QueueImplement();
        qu.push(1);
        qu.push(2);
        qu.push(3);
        qu.push(4);
        qu.push(5);
        qu.push(6);

        for (int i = 0; i < 6; i++) {
            System.out.println(qu.pop());
        }
    }
}
