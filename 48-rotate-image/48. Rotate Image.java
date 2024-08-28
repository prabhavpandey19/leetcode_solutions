class Solution {
    public void rotate(int[][] matrix) {
          int m=matrix.length;
        int n=matrix[0].length;
        
        
        //find Transpose of a matrix
        //catch here is j should point to i
        //if we set j to 0, then we will swap (0,1) -> (1,0) when i=0 and
        //again we will swap (1,0)->(0,1) when j starts with 0(i being 1) and hence it wont form a Transpose
        for(int i=0;i<m;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        //go by each row
        //swap 1st and last col val, 2nd and last 2nd col val and so on.
        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }
	 }
    
