class Solution {
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int[] row: dp)
            Arrays.fill(row, -1);
        return dfs(0,amount,coins,dp);
    }

    private static int dfs(int i, int amount, int[] coins, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (i == coins.length) {
            return 0;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        dp[i][amount] = dfs(i,amount-coins[i],coins, dp) + dfs(i+1,amount,coins, dp);
        return dp[i][amount];
    }
}