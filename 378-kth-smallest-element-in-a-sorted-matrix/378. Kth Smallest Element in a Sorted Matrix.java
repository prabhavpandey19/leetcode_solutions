class Solution {
    public int kthSmallest(int[][] matrix, int k) {
	        PriorityQueue<Integer> xIntegers=new PriorityQueue<Integer>(k);
	        for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					xIntegers.add(matrix[i][j]);
				}
			}
	        for (int i = 0; i < k-1; i++) {
				xIntegers.poll();
			}
	       return xIntegers.poll();
	    }
}