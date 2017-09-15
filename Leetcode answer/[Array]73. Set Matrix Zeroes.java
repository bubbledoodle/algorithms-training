// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// click to show follow up.

// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

// Time will always be O(mxn)
// 三板斧的优化过程，1是情况记录在另一个矩阵里。2进阶到直接记录一个行一个列。3可以inline的使用第一行列来记录。注意修改循环从1开始

class Solution {

    
    // Method 1 space complexity O(m+n)
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }   
        }
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if(row[i] == 1 || col[j] == 1) matrix[i][j] = 0;
            }
        }
    }

       // Method 2 space complexity O(1)
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean fr = false, fc = false;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) for(int j = 0; j < n; j++) matrix[0][j] = 0;
        if(fc) for(int i = 0; i < m; i++) matrix[i][0] = 0;
    }
}