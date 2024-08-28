class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i=0;i< grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfsIland(grid,i,j);
                }
            }
        }
        return 0;
    }

    private int dfsIland(int[][] grid,int i,int j) {
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        if (i < 0 || j<0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        int c =0;
        grid[i][j] = 2;
        for (int[] d:dirs) {
            c += dfsIland(grid, i + d[0] , j + d[1]);
        }
        for (int[] d:dirs) {
            if (i + d[0] < 0 || j + d[1] <0 || i + d[0] >= grid.length || j + d[1] >= grid[0].length || grid[i + d[0]][j + d[1]] == 0) {
                c++;
            }
        }
        return c;
    }

}