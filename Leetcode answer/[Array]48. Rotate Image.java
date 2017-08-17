// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// transpose ---> 中轴对称

public class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        symFlip(matrix);
    }
    private void transpose(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private void symFlip(int[][] matrix){
        int col = matrix[0].length;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col - 1 - j];
                matrix[i][col - 1 - j] = temp;
            }
        }
    }
}