class Solution {
    public static int characterReplacement(String s, int k) {
        Map<Character,Integer> frequency = new HashMap<>();
        int l=0;
        int max = 0;
        int maxf = 0;
        for(int r=0;r<s.length();r++){
            frequency.put(s.charAt(r),frequency.getOrDefault(s.charAt(r),0)+1);
            maxf = Math.max(frequency.getOrDefault(s.charAt(r),0),maxf);
            while (((r-l+1) - maxf) > k) {
                frequency.put(s.charAt(l),frequency.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
            max = Math.max(r-l+1,max);
        }
        return max;
    }
    private static int maxFre(Map<Character, Integer> frequency) {
        int max = 0;
        for (int c:frequency.values()) {
            max = Math.max(c,max);
        }
        return max;
    }
}