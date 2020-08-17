package com.liusx.sword.practice;

import java.util.Stack;

/**
 * description: Write <br>
 * date: 2020/8/17 10:50 <br>
 *
 * @author: liusx <br>
 * version: 1.0 <br>
 */
public class Write {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int param){
        stack1.push(param);
    }
    public int take(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
        Write write = new Write();
        write.push(1);
        write.push(2);
        write.push(3);
        write.push(4);
        write.push(5);
        write.push(6);
        write.push(7);
        write.push(8);
        for (int i = 0; i < 8; i++) {
            System.out.println(write.take());
        }
    }
}
