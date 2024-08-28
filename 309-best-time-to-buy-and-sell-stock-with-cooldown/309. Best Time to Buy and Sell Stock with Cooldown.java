class Solution {
    public int maxProfit(int[] prices) {
        Map<String,Integer> cache = new HashMap<>();
        return helper(prices, true, 0, cache);
    }

    private int helper(int[] prices, boolean b, int i, Map<String, Integer> cache) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + "_" + b;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int cooldown = helper(prices,b,i+1, cache);
        int x = Integer.MIN_VALUE;
        if (b) {
            x = helper(prices,!b,i+1, cache) - prices[i];
        } else {
            x = helper(prices,!b,i+2, cache) + prices[i];
        }
        cache.put(key, Math.max(x,cooldown));
        return cache.get(key);
    }
}