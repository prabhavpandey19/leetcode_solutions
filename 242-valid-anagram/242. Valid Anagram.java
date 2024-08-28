class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
        	return false;
        }
        Map<Character, Integer> ms=new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++) {
        	ms.put(s.charAt(i),ms.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0;i<t.length();i++) {
        	ms.put(t.charAt(i),ms.getOrDefault(t.charAt(i), 0)-1);
        	if(ms.get(t.charAt(i)).equals(0)) {
        		ms.remove(t.charAt(i));
        	}
        }
        return ms.size()==0;
    }
}