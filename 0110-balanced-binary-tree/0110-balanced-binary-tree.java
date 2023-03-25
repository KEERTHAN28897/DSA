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
    boolean flag = true;
    public int validate(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        int l = validate(node.left);
        int r = validate(node.right);
        
        if(Math.abs(r-l) > 1) {
            flag = false;
        }
        
        return Math.max(l, r) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
           validate(root);
           return flag;
        
    }
}