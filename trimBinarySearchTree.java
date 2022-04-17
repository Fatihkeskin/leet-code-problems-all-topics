package com.company;

public class Main {

    public static void main(String[] args) {
        // first input
        TreeNode a = new TreeNode(0, null, null);
        TreeNode c = new TreeNode(2, null, null);
        TreeNode b = new TreeNode(1, a, c);
        System.out.println(trimBST(b, 1 , 2).val);

        //second input
        TreeNode a1 = new TreeNode(1, null, null);
        TreeNode b1 = new TreeNode(2, a1, null);
        TreeNode c1 = new TreeNode(0, null, b1);
        TreeNode d1 = new TreeNode(4, null, null);
        TreeNode e1 = new TreeNode(3, c1, d1);
        System.out.println(trimBST(e1, 1 , 3).val);
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return root;
        if (root.val < low)
            return trimBST(root.right, low, high);
        if (root.val > high)
            return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }


   public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
