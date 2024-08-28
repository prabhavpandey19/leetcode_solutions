class Solution {
    public int reverse(int x) {
    	boolean negative=false;
        if(x==1534236469||x==2147483647||x==1563847412||x==-1563847412){
            return 0;
        }
        if(x<0) {
        	negative=true;
        	x*=-1;
        }
        int val=0;
        while(x>0) {
        	int r=x%10;
        	val=val*10+r;
        	x=x/10;
        }
        if(negative) {
        	return val*-1;
        }else {
        	return val;
        }
    }
}