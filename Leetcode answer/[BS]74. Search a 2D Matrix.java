// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,

// Consider the following matrix:

// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.

// 牛逼的一句话：Don't treat it as a 2D matrix, just treat it as a sorted list.


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col * row  - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(matrix[mid / col][mid % col] < target){
                left  = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[right / col][right % col] == target;
    }
}