class Solution {
   public boolean isValidSerialization(String preorder) {
	        int vac=1;
	        String[] aStrings=preorder.split(",");
	        for(String x:aStrings){
	        	vac--;
                if(vac<0){
                    return false;
                }
	        	if(x.equalsIgnoreCase("#")) {
	        		
	        	} else {
	        		vac+=2;
	        	}
	        }
	        return vac==0;
	        	
	        }

}