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
    
    int max = -1;
    
    public void right(TreeNode node, int level, List<Integer> res) {
        if(node == null) {
            return;
        }
        
        if(level > max) {
            res.add(node.val);
            max = level;
        }
        
        right(node.right, level+1, res);
        right(node.left, level+1, res);
        return;
        
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        right(root, 0, res);
        return res;
    }
}