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
class BSTIterator {

    private List<TreeNode> inOrderList = new ArrayList<>();
    private int currentNode = -1;
    
    public BSTIterator(TreeNode root) {        
        createInOrderList(root);        
    }
    
    private void createInOrderList(TreeNode root) {
        if (root == null)
            return;        
        
        createInOrderList(root.left);
        
        inOrderList.add(root);
        
        createInOrderList(root.right);
    }
    
    public int next() {
        return inOrderList.get(++currentNode).val;
    }
    
    public boolean hasNext() {
        return currentNode + 1 < inOrderList.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */