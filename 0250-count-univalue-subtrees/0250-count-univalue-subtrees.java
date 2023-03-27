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

class Custom {
    int val;
    boolean flag;
    
    Custom(int val, boolean flag) {
        this.val = val;
        this.flag = flag;
    }
}
class Solution {
    
    public  int leaf = 1001;
    int count = 0;
    public Custom rec(TreeNode node) {
        if(node == null) {
            return new Custom(1001, true);
        }
        
        Custom left = rec(node.left);
        Custom right = rec(node.right);
        if(left.flag == false || right.flag == false){
            return new Custom(node.val, false);
        }
        
        boolean flag = true;
        
        if(left.val == leaf && right.val == leaf) {
            count++;
        } else if(left.val == leaf && right.val == node.val) {
           count++;
        } else if(right.val == leaf && left.val == node.val) {
            count++;
        } else if(right.val == node.val && left.val == node.val) {
            count++;
        } else {
            flag = false;
        }
        
        
        return new Custom(node.val, flag);
        
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        rec(root);
        return count;
    }
}