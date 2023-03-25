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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue  = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>(); 
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null) {
                res.add(new ArrayList<>(curr));
                curr.clear(); 
                if(queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            } else {
                curr.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                
                if(node.right != null) {
                    queue.add(node.right);
                    
                }
            }   
        }
        return res;
        
    }
}