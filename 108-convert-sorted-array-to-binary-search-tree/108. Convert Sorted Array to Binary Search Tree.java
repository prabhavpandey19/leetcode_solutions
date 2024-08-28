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
  	  public TreeNode sortedArrayToBST(int[] nums) {
		        TreeNode xNode=helper(nums,0,nums.length-1);
		        return xNode;
		    }
	private TreeNode helper(int[] nums, int i, int j) {
			if(i>j) {
				return null;
			}
			int mid=(i+j)/2;
			TreeNode xNode=new TreeNode(nums[mid]);
			xNode.left=helper(nums, i, mid-1);
			xNode.right=helper(nums, mid+1, j);
			return xNode;
		}
}