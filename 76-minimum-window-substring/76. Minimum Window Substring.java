class Solution {
    public String minWindow(String s, String t) {
        if (t.length()>s.length()) {
            return "";
        }
        Map<Character,Integer> frequency = new HashMap<>();
        Map<Character,Integer> fs2 = new HashMap<>();
        int k = t.length();
        int l =0;
        for (int i = 0;i<k;i++) {
            frequency.put(t.charAt(i),frequency.getOrDefault(t.charAt(i),0)+1);
            fs2.put(s.charAt(i),fs2.getOrDefault(s.charAt(i),0)+1);
        }
        String res = "";
        int lenM = Integer.MAX_VALUE;
        if (containPer(fs2,frequency)) {
            res = s.substring(0,k);
            lenM = s.substring(0,k).length();
        }
        for (int i=k;i<s.length();i++) {
            fs2.put(s.charAt(i),fs2.getOrDefault(s.charAt(i),0)+1);
           while (containPer(fs2,frequency)) {
                if (lenM > s.substring(l,i+1).length()) {
                    res = s.substring(l,i+1);
                    lenM = res.length();
                }
                fs2.put(s.charAt(l),fs2.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
        }
        return res;
    }
    private static boolean containPer(Map<Character, Integer> setSub, Map<Character, Integer> set) {
        for (Map.Entry<Character, Integer> entry : set.entrySet()) {
            if (setSub.get(entry.getKey()) == null || setSub.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}