class Solution {
		 public int minSubArrayLen(int target, int[] nums) {
	        int left=0;
	        int sum=0;
	        int x=Integer.MAX_VALUE;
	        for(int i=0;i<nums.length;i++) {
	        	sum+=nums[i];
	        	while(sum>=target) {
	        		sum-=nums[left];
	        		x=Math.min(x, i+1-left);
	        		left++;
	        	}
	        }
            if(x==Integer.MAX_VALUE) {
	        	return 0;
	        }else {
	          return x;
	        }
	    }
}