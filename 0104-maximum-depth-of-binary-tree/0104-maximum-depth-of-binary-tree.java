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
    
    public int rec(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        if(node.left == null && node.right == null) {
            return 1;
        }
        
        int l = rec(node.left) + 1;
        int r = rec(node.right) + 1;
        
        return Math.max(l, r);
    }
    
    public int maxDepth(TreeNode root) {
        return rec(root);
    }
}