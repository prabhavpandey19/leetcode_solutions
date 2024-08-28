class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0)
            return res;
        String[] keypad={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs6(keypad,digits,res,new StringBuilder(),0);
        return res;
    }

    private void dfs6(String[] keypad, String digits, List<String> res, StringBuilder stringBuilder, int i) {
        if (i == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        String s = keypad[digits.charAt(i)-'0'];
        for (int j=0;j<s.length();j++) {
            stringBuilder.append(s.charAt(j));
            dfs6(keypad,digits,res,stringBuilder,i+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}