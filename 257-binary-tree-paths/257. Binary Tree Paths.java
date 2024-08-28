/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   	 public List<String> binaryTreePaths(TreeNode root) {
	        List<String> a=new ArrayList();
	        if(root!=null)helper(root,a,"");
	        return a;
	    }

	private void helper(TreeNode root, List<String> a, String string) {
		if(root.left==null&&root.right==null)a.add(string+root.val);
		if(root.left!=null) {
			helper(root.left, a, string+root.val+"->");
		}
		if(root.right!=null) {
			helper(root.right, a, string+root.val+"->");
		}
		
	}
}