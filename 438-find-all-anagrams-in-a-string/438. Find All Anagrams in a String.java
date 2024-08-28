class Solution {
     public List<Integer> findAnagrams(String s, String p) {
	   Map<Character, Integer> mpMap=new HashMap<Character, Integer>();
	   Map<Character, Integer> pMap=new HashMap<Character, Integer>();
	   for(int i=0;i<p.length();i++) {
		   pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0)+1);			
	   }
	   int l=0;
	   List<Integer> resIntegers=new ArrayList<Integer>();
	   for(int i=0;i<s.length();i++) {
			mpMap.put(s.charAt(i), mpMap.getOrDefault(s.charAt(i), 0)+1);
			if(i-l+1==p.length()) {
				if(com1as2(mpMap,pMap)) {
					resIntegers.add(l);
				}
				mpMap.put(s.charAt(l), mpMap.get(s.charAt(l))-1);
				l++;
			}
	   }
	   return resIntegers;
   }

	private boolean com1as2(Map<Character, Integer> mpMap, Map<Character, Integer> pMap) {
	for(Character x:pMap.keySet()) {
		if(!pMap.get(x).equals(mpMap.get(x))) {
			return false;
		}
	}
	return true;
}
}