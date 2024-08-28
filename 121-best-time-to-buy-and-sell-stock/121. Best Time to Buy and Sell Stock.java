class Solution {
    public int maxProfit(int[] prices) {
        int[] rMax = new int[prices.length];
        int rm = 0;
        for (int i = prices.length-1;i>=0;i--) {
            rMax[i] = rm;
            if (prices[i] > rm) {
                rm = prices[i];
            }
        }
        rMax[0] = rm;
        int res=0;
        for (int i=0;i<prices.length;i++) {
            if (rMax[i]-prices[i] > res) {
                res = rMax[i]-prices[i];
            }
        }
        return res;
    }
}