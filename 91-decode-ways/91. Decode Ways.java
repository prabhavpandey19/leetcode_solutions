class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        Arrays.fill(dp,1);
        for (int i = s.length()-1;i>=0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i+1];
            }
            if ((i+1 < s.length()) && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }

    private int decode(int i,int[] dp, String s) {
        if (s.length() == i) {
            return 1;
        }
        if (dp[i] != 1) {
            return dp[i];
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        int res = decode(i+1,dp,s);
        if ((i+1 < s.length()) && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
            res += decode(i+2,dp,s);
        }
        dp[i] = res;
        return res;
    }
}