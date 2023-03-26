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
    
    
    int nodes = 0;
    public boolean validateRight(TreeNode node, int count) {
        int rcount = 0;
        while(node != null) {
            rcount++;
            node = node.right;
        }
        
        if(rcount == count) {
            return true;
        }
        return false;
        
    }
    
    int getLeftCount(TreeNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.left;
        }
        return count;
    }
    
    public void rec(TreeNode node) {
        if(node == null) {
            return;
        }
        int count = getLeftCount(node);
        if(validateRight(node, count)) {
            nodes = nodes + (int)Math.pow(2, count) - 1;
        } else {
            nodes = nodes + 1;
            rec(node.left);
            rec(node.right);
        }
        return;
    }
    
    public int countNodes(TreeNode root) {
        rec(root);
        return nodes;
    }
}