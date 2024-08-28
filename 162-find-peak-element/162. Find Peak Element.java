class Solution {
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length;
        while (l<=r) {
            int m=l+(r-l)/2;
            if ((m-1>=0 && nums[m-1]<nums[m] )&&(m+1<nums.length && nums[m+1]<nums[m]) ) {
                return m;
            } else if (m+1<nums.length && nums[m+1]>nums[m]) {
                l = m+1;
            } else {
                r= m-1;
            }
        }
        return l;
    }
}