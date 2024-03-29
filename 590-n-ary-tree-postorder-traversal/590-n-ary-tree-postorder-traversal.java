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
    List<Integer> res;
    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        postOrder(root);
        return res;
    }
    
    private void postOrder(Node root) {
        if(root != null) {
            for(Node n : root.children) {
                postOrder(n);
            }
            res.add(root.val);
        }
    }
}