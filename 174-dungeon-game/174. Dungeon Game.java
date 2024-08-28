class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
    int row = dungeon.length-1;
    int col = dungeon[0].length-1;
    int[][] dp = new int[row+1][col+1];    
    
    // Min health required in last cell is 1 unless the cell has a deamon in it, 
    // then the min health required is 1 more than the absolute value of negative value in the cell
    dp[row][col] = Math.max(1, 1 - dungeon[row][col]); 
    
    for(int r=row; r >= 0; r--){
      for(int c=col; c >= 0; c--){
        // Ignoring the calculation of the last cell as we already did it
        if(r == row && c == col)
          continue;
        
        int minHealthToGoRight = minHealth(r, c, r, c+1, dungeon, dp);
        int minHealthToGoDown = minHealth(r, c, r+1, c, dungeon, dp);
        
        // Min health at r,c is the min health needed to go down or right
        dp[r][c] = Math.min(minHealthToGoRight, minHealthToGoDown);
      }
    }    
    return dp[0][0];
  }
  
  int minHealth(int currRow, int currCol, int nextRow, int nextCol, int[][] dungeon, int[][]dp){
    if(nextRow >= dungeon.length || nextCol >= dungeon[0].length)
      return Integer.MAX_VALUE;
    
    // Min health to move in a cell is 1 unless the next cell requires additional health,
    // then we calculate that and the max out of these 2 will be minHealth required to move into the next cell
    return Math.max(1, dp[nextRow][nextCol] - dungeon[currRow][currCol]);
  }
}