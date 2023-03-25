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
    int max = 0;
    public int max(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = max(root.left);
        int right = max(root.right);
        
        
        
        int val = left + right;
        if(val > max) {
            max = val;
        }
        
        return Math.max(left, right) + 1;
        
        
    }
    
    
    public int diameterOfBinaryTree(TreeNode root) {
        max(root);
        return max;
        
        
    }
}