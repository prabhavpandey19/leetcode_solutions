class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length+1];
        int[] dp2 = new int[nums.length+1];

        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);

        return Math.max(robH(0,nums, dp, nums.length-1) , robH(1,nums, dp2, nums.length));
    }

    private int robH(int i, int[] nums, int[] dp, int l) {
        if (i >= l){
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int s1 = nums[i] + robH(i+2, nums, dp, l);
        int s2 = robH(i+1, nums, dp, l);
        dp[i] = Math.max(s1,s2);
        return dp[i];
    }
}