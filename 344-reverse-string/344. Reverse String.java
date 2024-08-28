class Solution {
     public void reverseString(char[] s) {
         char sh;
        for (int i = 0,j = s.length -1; i < s.length/2;i++,j--) {
            sh = s[i];
            s[i] = s[j];
            s[j] = sh;
        }
    }
}