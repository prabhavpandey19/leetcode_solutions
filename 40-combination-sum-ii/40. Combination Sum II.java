class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs4(candidates,res,new ArrayDeque<Integer>(),0,0,target);
        return res;
    }

    private void dfs4(int[] candidates, List<List<Integer>> res, ArrayDeque<Integer> list, int i, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i >= candidates.length || sum > target) {
            return;
        }
        list.add(candidates[i]);
        dfs4(candidates,res,list,i+1,sum+candidates[i],target);
        list.removeLast();
        while (i+1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }
        dfs4(candidates,res,list,i+1,sum,target);
    }
}