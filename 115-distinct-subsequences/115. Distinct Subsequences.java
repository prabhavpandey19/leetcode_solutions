class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        if (t.equals("")) {
            return 1;
        }
        int[][] dp = new int[s.length()][t.length()];
        for (int[] d:dp) {
            Arrays.fill(d,-1);
        }
        return helper2(s,t,dp,0,0);
    }

    private int helper2(String s, String t, int[][] dp, int i, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (i >= s.length()) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int x;
        if (s.charAt(i) == t.charAt(j)) {
            x = helper2(s,t,dp,i+1,j) + helper2(s,t,dp,i+1,j+1);
        } else {
            x = helper2(s,t,dp,i+1,j);
        }
        dp[i][j] = x;
        return x;
    }
}