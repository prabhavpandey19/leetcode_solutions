class Solution {
 public static String frequencySort(String s) {
			
			Map<Character, Integer> aMap=new HashMap<Character, Integer>();
			PriorityQueue<Character> pq=new PriorityQueue<Character>((a,b)->(aMap.get(b)-aMap.get(a)));
			for(int i=0;i<s.length();i++) {
				if(aMap.containsKey(s.charAt(i))) {
				aMap.put(s.charAt(i), aMap.get(s.charAt(i))+1);
				}
				else {
					aMap.put(s.charAt(i), 1);
				}
			}
			for(Map.Entry<Character, Integer> x:aMap.entrySet()) {
				pq.add(x.getKey());
			}
			String anString="";
			while(pq.peek()!=null) {
				Character aCharacter=pq.poll();
				for(int i=0;i<aMap.get(aCharacter);i++) {
					anString+=aCharacter;
				}
			}
			return anString;
		}
}