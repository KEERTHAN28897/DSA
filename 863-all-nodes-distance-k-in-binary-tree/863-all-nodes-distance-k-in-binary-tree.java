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
    
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public void dfs(TreeNode node, TreeNode parent) {
        if(node == null) {
            return;
        }
        map.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        queue.add(null);
        int count = 0;
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
         List<Integer> ans = new ArrayList<>();
        if(k == 0) {
            ans.add(target.val);
            return ans;
        }
        
        while(queue.isEmpty() == false) {
            TreeNode node = queue.remove();
           
            if(node == null) {
                ++count;
                if(count == k) {
                    break;
                }
                queue.add(null);
                node = queue.remove();
                if(node == null) {
                    return ans;
                }
            }
              //System.out.println(node.val);
            
            TreeNode lnode = node.left;
            TreeNode rnode = node.right;
            TreeNode pnode = map.get(node);
            if(lnode != null && visited.contains(lnode) == false) {
                queue.add(lnode);
                visited.add(lnode);
            }
                
            if(rnode != null && visited.contains(rnode) == false) {
                queue.add(rnode);
                visited.add(rnode);
            }
                
            if(pnode != null && visited.contains(pnode) == false) {
                queue.add(pnode);
                visited.add(pnode);
            }
        }
        
        //System.out.println(queue);
       
        while(queue.isEmpty() == false) {
            ans.add(queue.remove().val);
        }
        return ans;
        
    }
}