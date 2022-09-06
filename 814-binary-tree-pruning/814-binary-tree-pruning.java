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

    public boolean containsOne(TreeNode node) {
        if (node == null) {
            return false;
        }

        boolean left = containsOne(node.left);
        boolean right = containsOne(node.right);
        if (!left) {
            node.left = null;
        }

        if (!right) {
            node.right = null;
        }

        boolean value = node.val == 1 ? true : false;

        return (left || right || value);
    }

    public TreeNode pruneTree(TreeNode root) {        
        boolean val = containsOne(root);
        if(val == false) {
            return null;
        }
        
        return root;
    }
}
