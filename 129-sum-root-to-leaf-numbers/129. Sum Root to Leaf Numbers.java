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
  	 public static int sumNumbers(TreeNode root) {
		 List<Integer> aIntegers=new ArrayList<Integer>();
	     sumRoot(root,0,aIntegers);
	     int sum=0;
	     for(Integer x:aIntegers) {
	    	 sum+=x;
	     }
	     return sum;
	       
	    }
	private static void sumRoot(TreeNode root, int i, List<Integer> aIntegers) {
		if(root==null) {
            return;
		}
		i=i*10+root.val;
		if(root.left==null&&root.right==null) {
			aIntegers.add(i);
		}
		sumRoot(root.left, i, aIntegers);
		sumRoot(root.right, i, aIntegers);		
	}
}