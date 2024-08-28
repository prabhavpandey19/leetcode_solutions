/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
     private static Map<Integer,Node> aMap=new HashMap<Integer, Node>();
	public Node connect(Node root) {
		int h=Height(root);
		for(int i=1;i<=h;i++) {
			levelOrder(root,i,i);
		}
		return root;
	}
	private void levelOrder(Node root, int i, int i2) {
		if(root==null) {
			return;
		}
		if(i==1) {
			if(aMap.containsKey(i2)) {
				aMap.get(i2).next=root;
				aMap.put(i2,root);
			}else {
				aMap.put(i2, root);
			}
		}
		levelOrder(root.left, i-1, i2);
		levelOrder(root.right, i-1, i2);
		
		
	}
	private int Height(Node root) {
		if(root==null) {
			return 0;
		}
		int lh=Height(root.left);
		int rh=Height(root.right);
		if(lh>rh) {
			return lh+1;
		}else {
			return rh+1;
		}

	}
}