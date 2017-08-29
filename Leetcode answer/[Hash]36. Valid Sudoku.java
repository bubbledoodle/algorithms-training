// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.

// 这个题就是要看看数独的格子是不是有效的 仅此而已。grid遍历，encoding有个过程。同行 同列 同9格一定要完成添加

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.') {
                   if(!seen.add(number + "in row " + i) ||
                      !seen.add(number + "in col " + j) ||
                      !seen.add(number + "in block " + i/3 + "-" + j/3))
                      return false;
                }
            }
        }
        return true;
    }
}