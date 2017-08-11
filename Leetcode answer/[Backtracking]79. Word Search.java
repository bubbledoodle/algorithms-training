// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

// 道：和之前的backtracking不一样的是循环入口在主method里，一旦进入搜索区，后续的调用才开始。
// bitmap没有再开辟一块地，而是board[y][x] ^= 256 
// 任一方向走的通就可以，所以有一串||


public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int y = 0; y < board.length; y++){
            for (int x = 0; x < board[y].length; x++){
                if(exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, int y, int x, char[] word, int len){
        if(len == word.length) return true;
        if(y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
        if(board[y][x] != word[len]) return false;
        
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, len+1)
		                || exist(board, y, x-1, word, len+1)
		                || exist(board, y+1, x, word, len+1)
		                || exist(board, y-1, x, word, len+1);
        board[y][x] ^= 256;
        
        return exist;
    }
}