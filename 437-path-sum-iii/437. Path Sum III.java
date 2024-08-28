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
    int count=0;
public int pathSum(TreeNode root, int targetSum) {
        if(root==null) {
        	return 0;
        }
        
        Helper(root,targetSum,0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        
        return count;
    }
	private void Helper(TreeNode root, int targetSum, int i) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		i+=root.val;
		if(targetSum==i) {
			count++;
		}
		Helper(root.left, targetSum, i);
		Helper(root.right,targetSum,i);
	}
}