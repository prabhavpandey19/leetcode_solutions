class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int prod=1;
        boolean containsZero=false;
        int count=0;
        for(int n:nums){
            if(n!=0){
                prod*=n;
            }else{
                count++;
                containsZero=true;;
            }
        }
        if(count>=2)
            return res;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                res[i]=prod;
            }else if(nums[i]!=0&&containsZero){
                res[i]=0;
            }else{
                res[i]=prod/nums[i];
            }
        }
        return res;
    }
}