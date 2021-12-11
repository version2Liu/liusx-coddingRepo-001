package com.liusx.structure.basic;

/**
 * @author ：liusx
 * @date ：Created in 2021/11/25 21:55
 * @description：基本的二叉树节点
 * @version: 1.0
 */
public class TreeNode {
    int val;
    TreeNode left,right;

    public TreeNode(int val){
        this.val = val;
    }
    static void traverse(TreeNode node){
        while(null!= node){
            System.out.println(node.val);

        }
    }

    static void traverseRecur(TreeNode root){
        traverse(root.left);
        traverse(root.right);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        traverseRecur(root);
    }
}
