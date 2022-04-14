/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode tempRoot = root;

        boolean found = true;

        while (tempRoot.val != val) {

            if (tempRoot.val > val) {
                if (tempRoot.left != null) {
                    tempRoot = tempRoot.left;
                } else {
                    found = false;
                    break;
                }
            } else if (tempRoot.val < val) {
                if (tempRoot.right != null) {
                    tempRoot = tempRoot.right;
                } else {
                    found = false;
                    break;
                }
            }
        }

        //if (found) {
      //      returnSubtree(tempRoot);
      //  }


        return found ? tempRoot : null;
    }
    
    public void returnSubtree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
        }
        
        returnSubtree(root.left);
        returnSubtree(root.right);
    }
}