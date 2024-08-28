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
 

	  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		  List<List<Integer>> zList=new ArrayList<List<Integer>>();
		  List<Integer> xIntegers=new ArrayList<Integer>();
		  sumRoot(root, xIntegers, zList,targetSum);
		  return zList;
		  
	   }
	  static int sum(List<Integer> xIntegers) {
		  int sum=0;
		     for(Integer x:xIntegers) {
		    	 sum+=x;
		     }
		     return sum;
	  }
	  private static void sumRoot(TreeNode root,List<Integer> x, List<List<Integer>> zList, int targetSum) {
			if(root==null) {
	            return;
			}
			x.add(root.val);
			if(root.left==null&&root.right==null) {
				if(sum(x)==targetSum)
					zList.add(new ArrayList<Integer>(x));
			}else{
                sumRoot(root.left, x, zList,targetSum);
                sumRoot(root.right,x, zList,targetSum);	
            }
            x.remove(x.size()-1);
		}
	
}