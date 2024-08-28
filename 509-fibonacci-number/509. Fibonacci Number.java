class Solution {
  	  int[] arr;
	  public int fib(int n) {
	        arr=new int[n+1];
	        for(int i=0;i<n+1;i++) {
	        	arr[i]=-1;
	        }
	        return fibo(n);
	  }
	private int fibo(int n) {
		if(arr[n]==-1) {
			int res;
			if(n==1||n==0) {
				res=n;
			}else {
				res=fibo(n-1)+fibo(n-2);
			}
			arr[n]=res;
		}
		return arr[n];
	}
}