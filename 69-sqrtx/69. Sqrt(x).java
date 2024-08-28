class Solution {
    public int mySqrt(int x) {
        int l = 1 ,r = x;
        while (l<=r) {
            int m = l + (r-l)/2;
            long sq = (long) m*m;
            if (sq == (long)x) {
                return m;
            } else if (sq > (long)x){
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return r;
    }
}