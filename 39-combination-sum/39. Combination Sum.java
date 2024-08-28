class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs2(candidates,res,new ArrayDeque<Integer>(),0,0,target);
        return res;
    }

    private void dfs2(int[] candidates, List<List<Integer>> res, ArrayDeque<Integer> list, int i, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i >= candidates.length || sum > target) {
            return;
        }
        list.add(candidates[i]);
        dfs2(candidates,res,list,i,sum+candidates[i],target);
        list.removeLast();
        dfs2(candidates,res,list,i+1,sum,target);
    }
}