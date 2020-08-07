package com.liusx.sword.day20200804.tree;

import java.util.List;

/**
 * description: Node <br>
 * date: 2020/8/4 14:46 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
