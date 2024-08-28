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
   public int[] findMode(TreeNode root) {
		List<Integer> a=new ArrayList<>();
		hhelper(root,a);
		int[] x=maxOccElement(a);
		return x;
	}

	private int[] maxOccElement(List<Integer> a) {
		Map<Integer, Integer> map=new HashMap<>();
		List<Integer> ac=new ArrayList<>();
		int max=0;
		for(int x:a) {
			map.put(x, map.get(x)==null?1:map.get(x)+1);
			if(map.get(x)>max) {
				max=map.get(x);
			}
		}
		for(Map.Entry<Integer, Integer> ab:map.entrySet()) {
			if(ab.getValue()==max) {
				ac.add(ab.getKey());
			}
		}
		int[] x=new int[ac.size()];
		for(int i=0;i<ac.size();i++) {
			x[i]=ac.get(i);
		}

		return x;
	}

	private void hhelper(TreeNode root, List<Integer> a) {
		if(root==null)return;
		hhelper(root.left, a);
		a.add(root.val);
		hhelper(root.right, a);
	}

}