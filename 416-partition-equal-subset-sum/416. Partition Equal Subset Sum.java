class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for (int x: nums) {
            sum+= x;
        }
        if (sum % 2 != 0) {
            return false;
        }
//        Map<String,Boolean> cache = new HashMap<>();
        int t = sum/2;
        // System.out.println(t);

        boolean[][] dp = new boolean[nums.length+1][t+1];
        return dfs(nums,t,0, dp);
    }

    private boolean dfs(int[] nums, int sum,int i, boolean[][] dp) {
        if (i >= nums.length|| sum < 0) {
            return false;
        }
        // System.out.println(sum);
        // System.out.println(i);
        if (dp[i][sum]) {
            return dp[i][sum];
        }
        if (sum == 0) {
            return true;
        }
        dp[i][sum] = dfs(nums,sum -nums[i],i+1, dp) || dfs(nums,sum,i+1, dp);
        return dp[i][sum];
    }

}