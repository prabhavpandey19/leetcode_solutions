class Solution {
    public int[] countBits(int n) {
		 	
	        int[] a=new int[n+1];
	        a[0]=0;
	        if(n==0) {
		 		return a;
		 	}
	        a[1]=1;
	        for(int i=2;i<=n;i++) {
	        	if(i%2==0) {
	        		a[i]=a[i/2];
	        	}else {
	        		a[i]=a[i/2]+1;
	        	}
	        }
	        return a;
	    }
}