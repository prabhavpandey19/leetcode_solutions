class Solution {
    int res = 0;
    public int uniquePaths(int m, int n) {
        res = 0;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], -1);
        }        
        return dfs(0,0,grid,m,n);
    }

    private int dfs(int i, int j, int[][] grid, int m, int n) {
        if (grid[i][j] != -1) {
            return grid[i][j];
        }
        if (i == m-1 && j == n-1) {
            return 1;
        }
        int path = 0;
        if (i < m-1) {
            path += dfs(i+1 , j,grid,m,n);
        }
        if (j < n-1) {
            path +=  dfs(i , j+1,grid,m,n);
        }
        grid[i][j] = path;
        return path;
    }


}