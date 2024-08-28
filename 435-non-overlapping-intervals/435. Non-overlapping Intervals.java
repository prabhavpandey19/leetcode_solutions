class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        int c = 0;
        Arrays.sort(nums,(a,b)->Integer.compare(a[0],b[0]));
        int[] prev = nums[0];
        for (int i =1;i<nums.length;i++) {
            if (prev[1] > nums[i][0]) {
                c++;
                if (prev[1] > nums[i][1]) {
                    prev = nums[i];
                }
            } else {
                prev = nums[i];
            }
        }
        return c;
     }
}