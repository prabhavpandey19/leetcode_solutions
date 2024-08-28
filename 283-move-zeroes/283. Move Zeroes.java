class Solution {
  public static void moveZeroes(int[] nums) {
        int i0 = 0;
        
        int j = i0+1;
        while (i0 < nums.length && j < nums.length) {
            if (nums[j] != 0) {
                nums[i0] = nums[j];
                nums[j] = 0;
                i0++;
            }
            j++;
        }
    }
}