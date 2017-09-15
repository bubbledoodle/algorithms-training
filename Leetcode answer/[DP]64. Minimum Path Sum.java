// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// 学到一个处理边界条件的方法，另外可以直接使用原来的矩阵

class Solution {
    public int minPathSum(int[][] dp) {
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = dp[i][j];
                } else if(i == 0 && j != 0){
                    dp[i][j] = dp[i][j - 1] + dp[i][j];
                } else if(i != 0 && j == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j];
                } else
                    dp[i][j] = dp[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}