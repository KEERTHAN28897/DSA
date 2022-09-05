/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root); queue.add(null);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            if(node == null) {
                res.add(new ArrayList<>(level));
                level.clear();
                if(queue.isEmpty()) {
                    return res;
                }
                queue.add(null);
            } else {
                level.add(node.val);
                List<Node> children = node.children;
                for(Node n : children) {
                    if(n != null)
                        queue.add(n);
                }
            }
        }
        return res;
    }
}