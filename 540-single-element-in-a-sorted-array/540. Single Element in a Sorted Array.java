class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<=r) {
            int m = l+(r-l)/2;
            if (!((m-1 >=0 && nums[m] == nums[m-1]) || (m+1 <nums.length &&nums[m] == nums[m+1]))) {
                return nums[m];
            }
            int rt = m,lt = m; 
            if (nums[m] == nums[m-1]) {
                rt = m-1;
            } else if (nums[m] == nums[m+1]) {
                lt = m+1;
            }
            if ((rt-l)%2==0) {
                l = lt +1;
            } else {
                r = rt-1;
            }
        }
        return -1;
    }
}