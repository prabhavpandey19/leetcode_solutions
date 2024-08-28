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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> a=new ArrayList();
        helper(root,a);
        return a;
    }
    void helper(TreeNode root,List<Integer> a){
        if(root==null)return;
        a.add(root.val);
        helper(root.left,a);
        helper(root.right,a);
    }
}