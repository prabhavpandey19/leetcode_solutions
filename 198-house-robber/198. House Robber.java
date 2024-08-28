class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return robH(0,nums, dp);
    }

    private int robH(int i, int[] nums, int[] dp) {
        if (i >= nums.length){
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int s1 = nums[i] + robH(i+2, nums, dp);
        int s2 = robH(i+1, nums, dp);
        dp[i] = Math.max(s1,s2);
        return dp[i];
    }
}