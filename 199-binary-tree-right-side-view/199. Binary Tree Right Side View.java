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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> ls:res) {
            if (ls.size() > 0) {
                ans.add(ls.get(ls.size()-1));
            }        
        }
        return ans;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null ) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i =0 ;i<n;i++) {
                TreeNode t = q.poll();
                list.add(t.val);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            res.add(list);
        }

        return res;
    }
}