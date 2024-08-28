class Solution {
    public int maxSubArray(int[] nums) {
        int a = 0;
        int max = Integer.MIN_VALUE;
        for(int x:nums) {
            if (a<0) {
                a=0;
            }
            a+=x;
            max = Math.max(a,max);
        }
        return max;
    }
}