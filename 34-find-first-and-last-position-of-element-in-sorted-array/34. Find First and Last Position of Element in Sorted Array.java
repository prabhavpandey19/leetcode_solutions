class Solution {
   	 public int[] searchRange(int[] nums, int target) {
	        int[] a=new int[2];
	        a[0]=-1;
	        a[1]=-1;
	        int l=0,r=nums.length-1;
	        while (l<=r) {
				int m=l+(r-l)/2;
				if(target==nums[m]) {
					while(l<=r) {
						if (target==nums[l]&&target==nums[r]) {
							a[0]=l;
							a[1]=r;
							return a;
						}
						if(target!=nums[l])
							l++;
						if(target!=nums[r])
							r--;
					}
				}
				if (nums[m]<target) {
					l=m+1;
				}else {
					r=m-1;
				}
				
			}
	        return a;
	    }
}