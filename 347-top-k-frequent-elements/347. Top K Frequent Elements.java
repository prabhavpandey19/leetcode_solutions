class Solution {
    public int[] topKFrequent(int[] nums, int k) {
	PriorityQueue<int[]> pQueue=new PriorityQueue<>((a,b)->{
		  if(a[1] == b[1]) return 0;
		 else if (a[1]<b[1]) {
			return 1;
		}else {
			return -1;
		}
          
	});
	Map<Integer, Integer> aMap=new HashMap<Integer, Integer>();
	for(int x:nums) {
		if(aMap.containsKey(x)) {
			aMap.put(x, aMap.get(x)+1);
		}else {
			aMap.put(x, 1);
		}
	}
	for(Map.Entry<Integer, Integer> z:aMap.entrySet()) {
		pQueue.add(new int[] {z.getKey(),z.getValue()});
	}
	int[] ans=new int[k];
	for(int i=0;i<k;i++) {
		ans[i]=pQueue.poll()[0];
	}
	return ans;
}
}