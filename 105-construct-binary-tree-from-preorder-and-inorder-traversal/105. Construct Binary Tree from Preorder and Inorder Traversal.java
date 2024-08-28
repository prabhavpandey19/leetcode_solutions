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
     int preIndex;
     public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0 ;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return buildT(preorder,inorder ,map , 0, preorder.length-1);
    }

    private TreeNode buildT(int[] preorder, int[] inorder, Map<Integer, Integer> map, int i, int l) {
        if (i>l) {
            return null;
        }
        int base = preorder[preIndex++];
        TreeNode root = new TreeNode(base);
        root.left = buildT(preorder,inorder,map,i,map.get(base)-1);
        root.right = buildT(preorder,inorder,map,map.get(base)+1,l);
        return root;
    }

}