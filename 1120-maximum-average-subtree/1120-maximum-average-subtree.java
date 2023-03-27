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
    double max;
    public int[] rec(TreeNode node) {
        if(node == null) {
            return new int[] {0, 0};
        }
        
        int[] left = rec(node.left);
        int[] right = rec(node.right);
        
        int sum = left[0] + right[0];
        int nodes = left[1] + right[1];
        
        double avg = (double)(sum + node.val) / (nodes + 1);
        
        if(avg > max) {
            max = avg;
        }
        
        return new int[] {sum + node.val, nodes+1};
        
    }
    public double maximumAverageSubtree(TreeNode root) {
        rec(root);
        return max;
    }
}