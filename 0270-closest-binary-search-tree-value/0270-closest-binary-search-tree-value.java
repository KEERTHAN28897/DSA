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
    int ans = Integer.MAX_VALUE;
    public void rec(TreeNode node, double target) {
        if(node == null) {
            return;
        }
        
        int val = node.val;
        double diff = Math.abs(node.val - target);
        double ansDiff = Math.abs(ans - target);
        double ldiff = Double.MAX_VALUE;
        double rdiff = Double.MAX_VALUE;
        
        if(diff < ansDiff) {
            ans = node.val;
        }
        
        if(node.left != null)
            ldiff = node.left.val;
        if(node.right != null)
            rdiff = node.right.val;
        
        
        if(target < node.val) {
            //answer can be never in right
            rec(node.left, target);
        } else {
            rec(node.right, target);
        }
        
        return;
    }
    
    public int closestValue(TreeNode root, double target) {
        rec(root, target);
        return ans;
    }
}