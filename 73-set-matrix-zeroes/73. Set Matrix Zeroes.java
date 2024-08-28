class Solution {
    public void setZeroes(int[][] matrix) {
		  ArrayList<int[]> arrList = new ArrayList<int[]>();
		  for(int i=0;i<matrix.length;i++) {
			  for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j]==0) {
					arrList.add(new int[]{i,j});
				}
			}
			  
		  }
		  for(int[] x:arrList) {
			  for (int i = 0; i < matrix.length; i++) {
				matrix[i][x[1]]=0;
			}
			  for (int i = 0; i < matrix[0].length; i++) {
				matrix[x[0]][i]=0;
			}
		  }
	    }
}