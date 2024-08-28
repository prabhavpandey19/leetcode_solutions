class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(a.containsKey(target-nums[i])) {
				return new int[] {a.get(target-nums[i]),i};
			}
			a.put(nums[i],i);
		}
		return null;
    }
}