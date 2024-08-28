class Solution {
    public static int removeDuplicates(int[] nums) {
        int l=1,r=1;
        while (l<nums.length && r<nums.length) {
            if (nums[r-1] != nums[r]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}