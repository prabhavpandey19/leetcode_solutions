class Solution {
     public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int res = nums[0];
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 0) {
                max = min = 1;
            }
            int temp = max * nums[i];
            max = Math.max(Math.max(min*nums[i], temp),nums[i]);
            min =  Math.min(Math.min(min*nums[i], temp),nums[i]);
            res = Math.max(max,res);
        }
        return res;
    }


}