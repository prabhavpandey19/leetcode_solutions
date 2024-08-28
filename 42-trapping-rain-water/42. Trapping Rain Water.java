class Solution {
   public static int trap(int[] height) {
        Map<Integer,Integer> rMax = new HashMap<>();
        int rmax = 0;
        for (int i=height.length-1;i>=0;i--) {
            rMax.put(i,rmax);
            if (height[i] > rmax) {
                rmax = height[i];
            }
        }
        int l=0,r=l+1;
        int lmax = height[0];
        int area = 0;
        while (l<r && r<height.length) {
            if (height[r] < Math.min(height[l],rMax.get(r))) {
                area += Math.min(height[l],rMax.get(r)) - height[r];
            } else {
                l = r;
            }
            r++;
        }
        return area;
    }
}