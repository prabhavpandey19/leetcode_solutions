class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
	        int[] dp=new int[nums.length];
	        for(int i=0;i<nums.length;i++) {
	        	dp[i]=0;
	        }
	        if(nums.length==1) {
	        	return 0;
	        }
	       
	        for(int i=2;i<nums.length;i++) {
	        	if(isAP(nums[i-2],nums[i-1],nums[i])) {
	        		dp[i]=dp[i-1]+1;
	        	}
	        }
	        int sum=0;
	        for(int i=0;i<dp.length;i++) {
	        	sum+=dp[i];
	        }
	        return sum;
	    }
	


	private boolean isAP(int i, int j, int k) {
		if((j-i)==(k-j)) {
			return true;
		}
		return false;
	}
}