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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(queue.isEmpty() == false) {
            TreeNode node = queue.remove();
            if(node == null) {
                if(queue.isEmpty()) {
                    return null;
                }
                queue.add(null);
                continue;
            }
            if(node == u) {
                if(queue.isEmpty()) {
                    return null;
                }
                return queue.remove();
            }
            
            if(node.left != null) {
                queue.add(node.left);
            }
            
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return null;
        
    }
}