class Solution {
    public boolean isPalindrome(String s) {
         if(s.length() == 0) {
            return false;
        }
        if (s.equals(" ")) {
            return true;
        }
        s= s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        int l =0 , r= s.length()-1;
        while (l<=r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}