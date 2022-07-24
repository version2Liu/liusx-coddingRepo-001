package com.liusx.topic.listNode;

/**
 * @author ：liusx
 * @date ：Created in 2022/7/23 22:14
 * @description：单链表结构
 * @version:
 */

public class SingleList<V> {
    V value;
    SingleList next;


    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public SingleList getNext() {
        return next;
    }

    public void setNext(SingleList next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleList{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
