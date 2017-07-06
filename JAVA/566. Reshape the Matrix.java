/*
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
*/

// same idea as writing CUDA program transformation
// TO NOTICE 2-D array manipulations:
// int row = nums.length;
// int col = nums[0].length;



public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (r*c != row*col) return nums;
        
        int[][] res = new int[r][c];
        for (int i=0; i<r*c; i++) {
            res[i/c][i%c] = nums[i/col][i%col];
        }
        return res;
    }
}
