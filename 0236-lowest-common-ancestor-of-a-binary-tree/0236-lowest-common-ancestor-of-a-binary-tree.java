/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode lca(TreeNode node, TreeNode a, TreeNode b) {
        if(node == null) {
            return null;
        }
        
        TreeNode left = lca(node.left, a, b);
        TreeNode right = lca(node.right, a, b);
        
        if(left != null && right != null) {
            if(left != right) {
                return node;
            }
            
            if(left == right) {
                return left;
            }
        }
        
        if(left != null && ((node == a) || (node == b))) {
            return node;
        }
           
        if(right != null && ((node == a) || (node == b))) {
            return node;
        }
           
        if(node == a || node == b) {
            return node;
        }
        
        if(left == null && right != null) {
            return right;
        }
        
         if(right == null && left != null) {
            return left;
        }
           
           
        return null;
        
        
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }
}