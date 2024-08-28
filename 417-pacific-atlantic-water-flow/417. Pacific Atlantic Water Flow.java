class Solution {
     public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> pacific =  new HashSet<>();
        for (int i =0 ;i< heights[0].length;i++) {
            if (!pacific.contains(0 + "_" + i)) {
                dfs(heights,pacific,0,i,-1,0,0);
            }
        }
        Set<String> altantic =  new HashSet<>();
        for (int i =0 ;i< heights[0].length;i++) {
            if (!altantic.contains((heights.length-1) + "_" + i)) {
                dfs(heights,altantic,heights.length-1,i,-1, heights.length-1, heights[0].length -1);
            }
        }
        pacific.retainAll(altantic);
        List<List<Integer>> res = new ArrayList<>();
        for (String s:pacific) {
            List<Integer> rs = new ArrayList<>();
            String[] ans = s.split("_");
            rs.add(Integer.parseInt(ans[0]));
            rs.add(Integer.parseInt(ans[1]));
            res.add(rs);
        }
        return res;
    }

    private void dfs(int[][] heights, Set<String> pacific, int i, int j, int parent, int bx, int by) {
        if (i < 0 || j<0 || i >= heights.length || j >= heights[0].length || pacific.contains(i + "_" + j)) {
            return;
        }
        if ( i == bx || j == by || heights[i][j] >= parent) {
            pacific.add(i + "_" + j);
        } else {
            return;
        }
        dfs(heights,pacific,i+1,j,heights[i][j], bx, by);
        dfs(heights,pacific,i-1,j,heights[i][j], bx, by);
        dfs(heights,pacific,i,j+1,heights[i][j], bx, by);
        dfs(heights,pacific,i,j-1,heights[i][j], bx, by);
    }
}