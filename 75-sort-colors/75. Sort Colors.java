class Solution {
    	public void sortColors(int[] nums) {
		int oneC=0;
		int twoC=0;
		int ZeroC=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0)
				ZeroC++;
			if(nums[i]==1)
				oneC++;
			if(nums[i]==2)
				twoC++;
			
		}
		int i = 0;
		for (i = 0; i < ZeroC; i++) {
			nums[i]=0;
		}
		for (; i < ZeroC+oneC; i++) {
			nums[i]=1;
		}
		for (; i < ZeroC+oneC+twoC; i++) {
			nums[i]=2;
		}
    }
}