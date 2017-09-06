// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// For example,
// Given n = 3,

// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

// 和第一道一个意思

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;
        
        while(num <= n * n){
            for(int i = left; i <= right; i++) matrix[top][i] = num++;
            top++;
            
            for(int i = top; i <= bottom; i++) matrix[i][right] = num++;
            right--;
            
            for(int i = right; i >= left; i--) matrix[bottom][i] = num++;
            bottom--;
            
            for(int i = bottom; i >= top; i--) matrix[i][left] = num++;
            left++;
        }
        return matrix;
    }
}