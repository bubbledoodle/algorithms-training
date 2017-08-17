// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// 11110
// 11010
// 11000
// 00000
// Answer: 1

// Example 2:

// 11000
// 11000
// 00100
// 00011
// Answer: 3

// 遍历grid, 清理走过的格子。套路依然是递归的开始要写出口条件(限制条件，这里为例就是ij的index限制以及grid[i][j]可能为零)；
// clearRestOfLand 对上下左右四邻域操作

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    clearRestOfLand(grid, i, j);
                }
            }
        }
        return count;
    }
    private void clearRestOfLand(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        clearRestOfLand(grid, i - 1, j);
        clearRestOfLand(grid, i + 1, j);
        clearRestOfLand(grid, i, j - 1);
        clearRestOfLand(grid, i, j + 1);
    }
}