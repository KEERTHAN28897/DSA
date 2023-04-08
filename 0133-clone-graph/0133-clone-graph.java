/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node dfs(Node node, Map<Integer, Node> visited) {
        
        if(node == null) {
            return null;
        }
        
        if(visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
                
        List<Node> neighbors = node.neighbors;
        ArrayList<Node> cloneNeighbors = new ArrayList<>();
        
        Node clone = new Node(node.val, cloneNeighbors);
        visited.put(node.val, clone);
        
        for(Node e : neighbors) {
            Node copy = dfs(e, visited);
            if(copy != null) {
                cloneNeighbors.add(copy);
                
            }
        }
        
        return clone;
    }
    
    public Node cloneGraph(Node node) {
        
        return dfs(node, new HashMap<>());
    }
}