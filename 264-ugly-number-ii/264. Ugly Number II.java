class Solution {
 public int nthUglyNumber(int n) {
	 PriorityQueue<Long> pq=new PriorityQueue<Long>();
        HashMap<Long, Boolean> map=new HashMap<>();
        
        pq.add((long) 1);
        map.put((long) 1, true);
        long res=0;
        
        for(int i=0;i<n;i++)
        {
            res=pq.poll();
            
            if(map.containsKey(res*2)==false)
            {
                pq.add(res*2);
                map.put(res*2, true);
            }
            
            if(map.containsKey(res*3)==false)
            {
                pq.add(res*3);
                map.put(res*3, true);
            }
            
            if(map.containsKey(res*5)==false)
            {
                pq.add(res*5);
                map.put(res*5, true);
            }
            
        }
        
        return (int) res;
	}
}