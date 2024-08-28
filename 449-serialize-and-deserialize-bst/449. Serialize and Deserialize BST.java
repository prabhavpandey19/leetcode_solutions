/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
   	 public  String serialize(TreeNode root) {
		 	StringBuilder xString=new StringBuilder();
	        preorder(root,xString);
	        return xString.toString();
	    }

	    private  void preorder(TreeNode root, StringBuilder xString) {
	    	if(xString.length()!=0)
	    		xString.append(",");
	    	if(root==null) {
	    		xString.append("#");
	    		return;
	    	}
	    	
	    	xString.append(root.val);
	    	preorder(root.left, xString);
		    preorder(root.right, xString);
	    }
		int i;
	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        String[] a=data.split(",");
	        i=0;
	        TreeNode node=buildTree(a);
	        return node;
	    }
		private TreeNode buildTree(String[] a) {
			if(a[i].equalsIgnoreCase("#")) {
				i++;
				return null;
			}
			TreeNode node=new TreeNode(Integer.parseInt(a[i]));
			i++;
			node.left=buildTree(a);
			node.right=buildTree(a);
			return node;
		}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;