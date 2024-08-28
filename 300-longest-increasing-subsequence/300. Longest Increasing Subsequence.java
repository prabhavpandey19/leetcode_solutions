class Solution {
   public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        
        for (int i=nums.length-1;i>=0;i--) {
            for (int j = i+1;j<nums.length;j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        
        return Arrays.stream(dp).max().orElse(0);
    }

}