class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs3(nums,res,new ArrayList<Integer>(),0);
        return res;
    }

    private void dfs3(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, int i) {
        if (i >= nums.length) {
            res.add(list.stream().collect(Collectors.toList()));
            return;
        }
        list.add(nums[i]);
        dfs3(nums,res,list,i+1);
        list.remove(list.size()-1);
        while (i+1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        dfs3(nums,res,list,i+1);
    }
}