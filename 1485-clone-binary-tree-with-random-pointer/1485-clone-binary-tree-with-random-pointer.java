/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    
    Map<Node, NodeCopy> hash = new HashMap<>();
    
    public NodeCopy dfs(Node node) {
        if(node == null) {
            return null;
        }       
     NodeCopy clone = new 
         NodeCopy(node.val, dfs(node.left), dfs(node.right), null);
        
        hash.put(node, clone);
        return clone;
    }
    
    
    public void assignPointer(NodeCopy clone, Node node) {
        if(node == null) {
            return;
        }
         
        assignPointer(clone.left, node.left);
        assignPointer(clone.right, node.right);
        
        NodeCopy random = hash.get(node.random);
        clone.random = random;
        
    }
    
    public NodeCopy copyRandomBinaryTree(Node root) {
        NodeCopy ans = dfs(root);
        assignPointer(ans, root);
        return ans;
    }
}