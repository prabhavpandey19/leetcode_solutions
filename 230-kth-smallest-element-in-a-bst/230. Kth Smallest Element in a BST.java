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
    int c=0;
    int e = -1;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return e;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left,k);
        c++;
        if (c==k) {
            e = root.val;
            c++;
            return;
        }
        inOrder(root.right,k);
    }
}