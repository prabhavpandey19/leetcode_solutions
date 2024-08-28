class Solution {
   public static List<List<Integer>> generate(int numRows) {
			List<List<Integer>> a=new ArrayList<>();
			List<Integer> row=new ArrayList<>();
			row.add(1);
			a.add(row);
			if(numRows==1) {
				return a;
			}
			for(int i=1;i<numRows;i++) {
				row=new ArrayList<>();
				row.add(1);
				for(int j=1;j<i;j++) {
					row.add(a.get(i-1).get(j)+a.get(i-1).get(j-1));					
				}
				row.add(1);
	            a.add(row);
			}
			return a;
		}
}