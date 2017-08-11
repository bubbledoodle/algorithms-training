/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

/*
    1 1 1 1 1 1 1 1 
    1 2 3 4 。。。。。
    1 。。。。。。。。。

    DP方程好写

*/

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 || j==0) res[i][j] = 1;
                else res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }
}