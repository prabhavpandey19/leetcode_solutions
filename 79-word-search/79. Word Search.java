class Solution {
       public static boolean exist(char[][] board, String word) {
        Set<String> set = new HashSet<>();
        Boolean res = false;
        for (int i=0;i < board.length;i++){
            for (int j=0;j<board[0].length;j++) {
                res = res || dfs7(0,board,i,j,word, set);
            }
        }
        return res;
    }

    private static boolean dfs7(int k, char[][] board, int i, int j, String word, Set<String> set) {
        if (k == word.length()) {
            return true;
        }
        if (i<0 || i >= board.length || j<0 || j >= board[0].length || set.contains(i+"-"+j) || word.charAt(k)!=board[i][j]) {
            return false;
        }
        set.add(i+"-"+j);
        boolean res = dfs7(k+1,board,i+1,j,word, set) || dfs7(k+1,board,i,j+1,word, set)
                || dfs7(k+1,board,i-1,j,word, set) || dfs7(k+1,board,i,j-1,word, set);
        set.remove(i+"-"+j);
        return res;
    }

}