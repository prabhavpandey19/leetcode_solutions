class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
	        int sumG=0,sumC=0;
	        for (int i = 0; i < cost.length; i++) {
				sumC+=cost[i];
				sumG+=gas[i];
			}
	        if(sumG<sumC)
	        	return -1;
	        
	        int total=0,index=0;
	        
	        for (int i = 0; i < cost.length; i++) {
				total+=gas[i]-cost[i];
				if(total>=0) {
					if(!(total-(gas[i]-cost[i])>0)) {
						index=i;
					}
				}else {
					index=-1;
					total=0;
				}
			}
	        return index;
	  }
}