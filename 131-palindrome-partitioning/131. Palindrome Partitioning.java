class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs5(s,res,new ArrayDeque<String>(),0);
        return res;
    }

    private void dfs5(String s, List<List<String>> res, ArrayDeque<String> list, int i) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j=i;j<s.length();j++) {
            if (palindrome(s.substring(i,j+1))) {
                list.add(s.substring(i,j+1));
                dfs5(s,res,list,j+1);
                list.removeLast();
            }
        }
    }

    private boolean palindrome(String substring) {
        int i = 0;
        int j = substring.length()-1;
        while (i < j) {
            if (substring.charAt(i) != substring.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}