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
class BSTIterator {
    int i=0;
    List<Integer> aIntegers=new ArrayList<>();
    public BSTIterator(TreeNode root) {
         inorder(root);
    }
    
    public int next() {
        int x=aIntegers.get(i++);
        return x;
    }
    
    public boolean hasNext() {
        return i<aIntegers.size();
    }
     private void inorder(TreeNode root) {
			if(root==null)return;
			inorder(root.left);
			aIntegers.add(root.val);
			inorder(root.right);
		}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */