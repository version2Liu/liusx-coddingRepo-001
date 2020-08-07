package com.liusx.juc.map.seven;

import java.util.HashMap;

/**
 * description: Entry <br>
 * date: 2020/7/28 20:06 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class Entry {

    String key;

    String value;

    int hashCode;

    Entry next;

    public Entry(String key, String value, int hashCode, Entry next) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", hashCode=" + hashCode +
                ", next=" + next +
                '}';
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public int getHashCode() {
        return hashCode;
    }

    public Entry getNext() {
        return next;
    }
}
