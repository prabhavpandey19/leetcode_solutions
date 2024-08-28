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
    public List<Integer>  postorder(Node root) {
        List<Integer> a=new ArrayList<>();
        postorder(root,a);
        return a;
    }
    void postorder(Node root,List<Integer> a){
        if(root==null){
            return;
        }
        for(Node c:root.children){
            postorder(c,a);
        }
        a.add(root.val);
    }
}