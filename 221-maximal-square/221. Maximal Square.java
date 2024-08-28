class Solution {
    	 public int maximalSquare(char[][] matrix) {
	     int[][] dp=new int[matrix.length+1][matrix[0].length+1];
	     int max=Integer.MIN_VALUE;
	     for(int i=matrix.length-1;i>0;i--) {
	    	 for(int j=matrix[0].length-1;j>0;j--) {
	    		 if(matrix[i][j]=='1') {
	    			 if(dp[i+1][j]==0||dp[i][j+1]==0||dp[i+1][j+1]==0) {
	    				 dp[i][j]=1;
	    			 }else {
	    				 dp[i][j]=1+dp[i+1][j+1];
	    			 }
	    		 }else {
	    			 dp[i][j]=0;
	    		 }
	    		 if(dp[i][j]>max) {
	    			 max=dp[i][j];
	    		 }
	    	 }
	     }
	     return max*max;
	    }
}