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
    int a=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return a;
    }
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = 1 + depth(root.left);
        int r = 1 + depth(root.right);
        a = Math.max(l+r-2,a);
        return Math.max(l,r);
    }
}