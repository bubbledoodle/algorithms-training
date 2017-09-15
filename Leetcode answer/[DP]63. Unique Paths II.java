// Follow up for "Unique Paths":

// Now consider if some obstacles are added to the grids. How many unique paths would there be?

// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.

// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.

// 动态方程：grid[i][j] = grid[i - 1][j] + grid[i][j - 1]; 
//     由于是只扫描一遍 并且动态方程里retrieve到的两个量都一定在左或上（一定已经操作过）
//     所以这样的inplace改变 把存在grid里边的数字变成path数量可行。
// 一大群if statement：先去掉1的情况 初始条件的设定由于1已走 可以大胆写1
// 关于第一排第一列的问题，由于不存在靠推得到grid[0][0] 
    对于之前的要求也就不存在了。不会造成indexException

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1) grid[i][j] = 0;
                else if(i == 0 && j == 0) grid[i][j] = 1;
                else if(i == 0) grid[i][j] = grid[i][j - 1] * 1;
                else if(j == 0) grid[i][j] = grid[i - 1][j] * 1;
                else grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[rows - 1][cols - 1];
    }
}