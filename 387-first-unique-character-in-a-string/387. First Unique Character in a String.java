class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> mpMap=new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
			mpMap.put(s.charAt(i), mpMap.getOrDefault(s.charAt(i), 0)+1);
		}
        for (int i = 0; i < s.length(); i++) {
        	if(mpMap.get(s.charAt(i))==1) {
        		return i;
        	}
        }
        return -1;
    }
}