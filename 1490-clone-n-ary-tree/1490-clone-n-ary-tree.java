/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    
    public Node clone(Node node) {
        if(node == null) {
            return null;
        }
        
        ArrayList<Node> childList =  new ArrayList<>();
        Node cloneNode = new Node(node.val, childList);
        List<Node> children = node.children;
        
        for(Node child : children) {
            childList.add(clone(child));
        }
        return cloneNode;
    }
    
    public Node cloneTree(Node root) {
        Node cloneNode = clone(root);
        return cloneNode;
    }
}