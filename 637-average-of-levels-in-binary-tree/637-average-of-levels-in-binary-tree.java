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
    public List<Double> averageOfLevels(TreeNode root) {
        //level order tarversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Double> ans = new ArrayList<>();
        double sum = 0;
        int count = 0;
        while(queue.isEmpty() == false) {
            TreeNode node = queue.remove();
            if(node == null) { 
                double res = sum / count;
                ans.add(res);
                sum = 0;
                count = 0;
                if(queue.isEmpty()) {
                    return ans;
                }
                node = queue.remove();
                queue.add(null);
            }
            
            sum += node.val;
            count++;
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);  
        }
        return ans;
        
    }
}