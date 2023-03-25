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
    public boolean checkTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        if(root.left == null && root.right == null) {
            return true;
        }
        
        int lval = (root.left != null) ? root.left.val : 0;
        int rval = (root.right != null) ? root.right.val : 0;
        
        if (root.val != (lval + rval)) {
           return false;
        }
        
        if(!checkTree(root.left))
            return false;
        
          if(!checkTree(root.right))
            return true;
        
        return true;
        
        
        
        
    }
}