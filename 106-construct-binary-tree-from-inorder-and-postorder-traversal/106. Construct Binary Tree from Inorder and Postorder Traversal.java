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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len=postorder.length;
		        return mapTree(postorder,inorder,len);
    }
     static HashMap<Integer, Integer> mp=new HashMap<Integer, Integer>();
			static int ind=0;
		private TreeNode mapTree(int[] preorder, int[] inorder, int len) {
			for(int i=0;i<len;i++) {
				mp.put(inorder[i],i);
			}
			ind=len;
			return buildTree(preorder,0,len-1);
		}

		private TreeNode buildTree(int[] preorder, int start, int end) {
			if(start>end) {
				return null; 
			}
			int curr=preorder[--ind];
			TreeNode node=new TreeNode(curr);
			int pos=mp.get(curr);
			if(start==end) {
				return node;
			}
			node.right=buildTree(preorder,  pos+1, end);
			node.left=buildTree(preorder,  start, pos-1);
			return node;
		}
}