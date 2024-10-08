class Solution {
   public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        return find(grid, m - 1, n - 1, dp);
    }

    private int find(int[][] grid, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i<0 || j<0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = grid[i][j] + Math.min(find(grid,i-1,j,dp),find(grid,i,j-1,dp));
        return dp[i][j];

    }
}