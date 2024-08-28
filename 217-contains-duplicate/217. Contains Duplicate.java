class Solution {
    public boolean containsDuplicate(int[] nums) {
	     Set<Integer> dubSet=new HashSet<Integer>();
	     for(int s:nums){
	    	 if(dubSet.contains(s)) {
	    		 return true;
	    	 }else {
	    		 dubSet.add(s);
	    	 }
	     }
	     return false;
	    }
}