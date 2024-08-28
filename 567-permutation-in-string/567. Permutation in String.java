class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        Map<Character,Integer> frequency = new HashMap<>();
        for (char c:s1.toCharArray()) {
            frequency.put(c,frequency.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> fs2 = new HashMap<>();
        int k = s1.length();
        for (int i = 0;i<k;i++) {
            fs2.put(s2.charAt(i),fs2.getOrDefault(s2.charAt(i),0)+1);
        }
        if (containPer(fs2,frequency)) {
            return true;
        }
        for (int i=k;i<s2.length();i++) {
            char key1 = s2.charAt(i);
            fs2.put(key1,fs2.getOrDefault(key1,0)+1);
            char key2 = s2.charAt(i - k);
            fs2.put(key2,fs2.getOrDefault(key2,0)-1);
            if (containPer(fs2,frequency)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containPer(Map<Character, Integer> b, Map<Character, Integer> a) {
        for(char key:a.keySet()) {
			if(!a.get(key).equals(b.get(key))) {
				return false;
			}
		}
        return true;
    }

}