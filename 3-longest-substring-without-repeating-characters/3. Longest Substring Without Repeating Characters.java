class Solution {
   public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l=0,r=l;
        int max = 0;
        while (l<s.length()) {
            while (set.contains(s.charAt(l))) {
                set.remove(s.charAt(r));
                r++;
            }
            set.add(s.charAt(l));
            max = Math.max(l-r+1,max);
            l++;
        }
        return max;
    }
}