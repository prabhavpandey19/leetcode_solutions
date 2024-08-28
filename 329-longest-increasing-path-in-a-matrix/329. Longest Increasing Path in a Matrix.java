class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] d:dp) {
            Arrays.fill(d,-1);
        }
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j< matrix[0].length;j++) {
                if (dp[i][j] == -1) {
                    dfs11(matrix,dp,i,j,matrix.length,matrix[0].length,-1);
                }
            }
        }
        int max=0;
        for (int[] d:dp) {
            for (int x:d) {
                max =Math.max(max,x);
            }
        }
        return max;
    }

    private int dfs11(int[][] matrix, int[][] dp, int i, int j, int n, int m, int parant) {
        if (i >= n || i < 0 || j >= m || j < 0 || parant >= matrix[i][j]) {
            return 0;
        }
        int p = matrix[i][j];
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = dfs11(matrix,dp,i,j-1,n,m,p);
        int right = dfs11(matrix,dp,i,j+1,n,m,p);
        int top = dfs11(matrix,dp,i-1,j,n,m,p);
        int bottom = dfs11(matrix,dp,i+1,j,n,m,p);
        dp[i][j] = 1+ Math.max(Math.max(left,right),Math.max(top,bottom));
        return dp[i][j];
    }
}