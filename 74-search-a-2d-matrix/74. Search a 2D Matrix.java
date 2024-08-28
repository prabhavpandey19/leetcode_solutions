class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int n=matrix.length,m=matrix[0].length;
      for (int i = 0; i < matrix.length; i++) {
		if(target<=matrix[i][m-1]) {
			return binarySearch(matrix[i],target);
		}
	}
      return false;
    }
	private boolean binarySearch(int[] is, int target) {
		int l=0,r=is.length;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(is[mid]==target) {
				return true;
			}
			if (is[mid]>target) {
				r=mid-1;
			}else {
				l=mid+1;
			}
		}
		return false;
	}
}