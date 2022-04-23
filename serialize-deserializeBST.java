package com.company;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        c.left = d;
        c.right = e;
        Main main = new Main();

        TreeNode ans = main.deserialize(main.serialize(a));
        System.out.println(main.serialize(a));
        TreeNode ans1 = main.deserialize("1,2,3,null,null,4,5");
        System.out.println(ans1);
    }


      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> serializeQueue = new ArrayDeque<>();
            StringBuilder result = new StringBuilder();

            serializeQueue.add(root);
            while (!serializeQueue.isEmpty()) {
                TreeNode current = serializeQueue.poll();
                result.append(current.val);

                if (current.left != null)
                    serializeQueue.add(current.left);


                if (current.right != null)
                    serializeQueue.add(current.right);


                if (!serializeQueue.isEmpty())
                    result.append(",");
            }

            return result.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodess = data.split(",");

            HashMap<Integer, Boolean> isCreated = new HashMap<>();
            for (int i = 0; i<nodess.length; i++) {
                isCreated.put(i,false);
            }
            TreeNode root = null;
            for (int j = 0; j<nodess.length; j++) {
                if (!isCreated.get(j) && !nodess[j].equals("null") ) {
                    TreeNode newNode = new TreeNode(Integer.valueOf(nodess[j]));
                    if (j == 0)
                        root = newNode;

                    int level = findLevel(j+1);
                    int leftChildIndex = (int) Math.pow(2, level);
                    leftChildIndex += j;
                    int rightChildIndex = leftChildIndex + 1;

                    if (leftChildIndex < nodess.length && nodess[leftChildIndex] != null ) {
                        newNode.left = new TreeNode(Integer.valueOf(nodess[leftChildIndex]));
                        isCreated.put(leftChildIndex, true);
                    }

                    if (rightChildIndex < nodess.length && nodess[rightChildIndex] != null ) {
                        newNode.right = new TreeNode(Integer.valueOf(nodess[rightChildIndex]));
                        isCreated.put(rightChildIndex, true);
                    }
                    isCreated.put(j, true);
                }
            }
            return root;
        }

        public int findLevel(int index) {
            for (int i = 0; i < 100; i++) {
                if (index >= Math.pow(2, i) && index < Math.pow(2, i + 1)) {
                    return i;
                }
            }
            return 0;
        }




// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}