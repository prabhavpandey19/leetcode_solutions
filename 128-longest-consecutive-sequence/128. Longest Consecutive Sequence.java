class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int maxLen=0;
        for(int n:nums){
            if(!set.contains(n-1)){
                int l=0;
                while(set.contains(n+l)){
                    l++;
                    
                }
                maxLen=Math.max(l,maxLen);
            }
        }
        return maxLen;
    }
}