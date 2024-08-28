class Solution {
      public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i<=amount;i++) {
            for (int c:coins) {
                if (i-c >= 0 && dp[i-c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i],1+dp[i-c]);
                }
            }
        }
        int ans = dp[amount];
        return (ans == Integer.MAX_VALUE) ?  -1 : ans;
    }

    private int getCount(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i:coins) {
            int count = getCount(coins, amount - i, dp);
            if (count != Integer.MAX_VALUE)
                min = Math.min(min,  1 + count);
        }
        dp[amount]=min;
        return min;
    }
}