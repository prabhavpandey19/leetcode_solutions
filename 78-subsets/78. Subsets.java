class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        sub(nums,res,new ArrayList<Integer>(),0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, int i) {
        if (i >= nums.length) {
            res.add(list.stream().collect(Collectors.toList()));
            return;
        }
        list.add(nums[i]);
        dfs(nums,res,list,i+1);
        list.remove(list.size()-1);
        dfs(nums,res,list,i+1);
    }

    public static void sub(int[] nums,List<List<Integer>> ll,List<Integer> result,int idx){
        ll.add(new ArrayList<>(result));
        for(int i=idx;i<nums.length;i++){
            // adding element
            result.add(nums[i]);
            sub(nums,ll,result,i+1);  //i+1 for unique elements 
            // removing element (backtracking)     
            result.remove(result.size()-1);
        }
        
    }
}