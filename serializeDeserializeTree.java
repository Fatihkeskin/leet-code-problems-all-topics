/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
            static int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Stack<TreeNode> serializeStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        serializeStack.push(root);
        while (!serializeStack.isEmpty()) {
            TreeNode current = serializeStack.pop();
            if (current == null) {
                result.append('X');
            } else {
                result.append(current.val);

                serializeStack.push(current.right);
                serializeStack.push(current.left);
            }

            if (!serializeStack.isEmpty())
                result.append(",");
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        String[] nodes = data.split(",");
        return deserializeHelper(nodes);
    }
    
            public static TreeNode deserializeHelper(String[] nodes) {
            if (nodes[index].equals("X"))
                return null;
            TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
            index++;
            root.left = deserializeHelper(nodes);
            index++;
            root.right = deserializeHelper(nodes);
            return root;
        }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));