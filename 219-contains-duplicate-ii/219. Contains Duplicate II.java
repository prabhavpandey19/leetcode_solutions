class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> hashSet = new HashSet<>();
        int i = 0;
        int j = 0;
        
        while (i<nums.length) {
			// step 1:
			// check, if can add, adds and continue step 2, else return true and finishes
            if (!hashSet.add(nums[i])){
                return true;
            }
			// step 2:
			// in the first step, all values will be added and if j-i is equal or greater than k, remove item and increase j for next window.
            if(i-j>=k){
                hashSet.remove(nums[j]);
                j++;
            }
			// step 3: 
			// Increase i, independently.
			i++;
        }
		// step 4:
		// return false
        return false;
    }
}