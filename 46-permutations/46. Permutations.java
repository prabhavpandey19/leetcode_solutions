class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(); // create new List and store result in List in List
        helper(nums,list,0);//here create helper function
        return list;//after return list
    }

    private void helper(int[] nums, List<List<Integer>> list, int idx){
        if(idx == nums.length-1){//here check idx equals to nums.length-1
            List<Integer> res = new ArrayList<>();//create new List because add all Permutations in res
            for(int i=0; i<nums.length; i++){
                res.add(nums[i]);//here all swap number add in res List
            }
            list.add(res);//afeter all Permutations add in list
            return;//successful all Permutations add in list so return recursion 
        }
        //here idx track index in nums
        for(int i=idx; i<nums.length; i++){//Iterate loop idx to nums.length-1  
            swap(nums,i,idx); //here swap number i to idx (i,and idx both index)
            helper(nums,list,idx+1); //call recursion helper function and increase idx + 1
            swap(nums,i,idx); // again call idx+1 
        }
    }
    private void swap(int[] nums,int i,int j){ //this function swap number 
        int temp = nums[i];//create new temp vairable and store nums[i] number
        nums[i]  = nums[j]; //here swap number i to j that`s means nums[j] replace nums[i]  
        nums[j] = temp; //here swap number j to temp that`s means temp replace nums[i]  
    }
}