class Solution {
    public boolean canJump(int[] nums) {
        int maxR=0;
        for(int i=0;i< nums.length;i++) {
            if (i>maxR) {
                return false;
            }
            if (maxR < (i+nums[i])) {
                maxR = i+nums[i];
            }
        }
        return true;
    }
}