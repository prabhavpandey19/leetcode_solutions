class Solution {
    public static int maxArea(int[] height) {
        int mArea = Integer.MIN_VALUE;
        int l =0 , r= height.length-1;
        while (l<=r) {
            if (height[l] > height[r]){
                mArea = Math.max(mArea,height[r]*(r-l));
                r--;
            } else if (height[l] < height[r]) {
                mArea = Math.max(mArea,height[l]*(r-l));
                l++;
            } else {
                mArea = Math.max(mArea,height[l]*(r-l));
                l++;
                r--;
            }
        }
        return mArea;
    }


}