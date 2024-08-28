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
   public List<Integer> preorder(Node root) {
		 List<Integer> a=new ArrayList<Integer>();
		 Helper(root,a);
		 return a;
	 }

	private void Helper(Node root, List<Integer> a) {
		if(root==null)return;
		a.add(root.val);
		for(Node c:root.children) {
			Helper(c,a);
		}
    }
		

}