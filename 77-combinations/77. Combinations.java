class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs2(k,1,n,new ArrayDeque<Integer>(),res);
        return res;
    }

    private void dfs2(int k, int i, int n, ArrayDeque<Integer> objects, List<List<Integer>> res) {
        if (objects.size() == k) {
            res.add(new ArrayList<>(objects));
            return;
        }
        if (objects.size() > k || i > n) {
            return;
        }
        objects.add(i);
        dfs2(k,i+1,n,objects,res);
        objects.removeLast();
        dfs2(k,i+1,n,objects,res);
    }
}