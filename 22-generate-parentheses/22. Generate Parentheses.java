class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        helper(0,0,res,stack,n);
        return res;
    }

    private void helper(int oc, int cc, List<String> res, Stack<Character> stack, int n) {
        if (oc == cc && oc == n) {
            res.add(stackToString(stack));
        }
        if (oc < n) {
            stack.push('(');
            helper(oc+1,cc,res,stack,n);
            stack.pop();
        }
        if (oc > cc) {
            stack.push(')');
            helper(oc,cc+1,res,stack,n);
            stack.pop();
        }
    }
    public static String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}