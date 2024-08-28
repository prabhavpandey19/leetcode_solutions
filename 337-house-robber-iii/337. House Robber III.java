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
    public int rob(TreeNode root) {
		List<List<Integer>> a=new ArrayList<>();
        int h=Height(root);
        for(int i=1;i<=h;i++) {
        	List<Integer> v=new ArrayList<>();
        	levelOrder(root,i,v);
        	a.add(v);
        }
        int oddSum=0;
        int evenSum=0;
        for(int i=1;i<=a.size();i++) {
        	if(i%2==0) {
        		evenSum+=Sum(a.get(i-1));
        	}else {
        		oddSum+=Sum(a.get(i-1));
        	}
        }
        if(evenSum>oddSum) {
        	return evenSum;
        }else {
        	return oddSum;
        }
    }
	private int Sum(List<Integer> list) {
			int sum=0;
			for(Integer x:list) {
				sum+=x;
			}
			return sum;
	}
	private void levelOrder(TreeNode root, int i, List<Integer> v) {
		if(root==null) {
			return;
		}
		if(i==1) {
			v.add(root.val);
		}else if(i>1){
		levelOrder(root.left,i-1,v);
		levelOrder(root.right,i-1,v);
    }
	}
	private int Height(TreeNode root) {
		if(root==null)return 0;
		int lh=Height(root.left);
		int rh=Height(root.right);
		if(lh>rh) {
			return lh+1;
		}else {
			return rh+1;
		}
	}
}