/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

/*
 1. 强行的string method, 处理方式暴力至极
 2. StringBuffer[] sb = new StringBuffer[n], then all the good append can be used.
 3. i作为char array的游子一直在加，row因为上上下下带着sb[row]去了个各row
*/



public class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int n = s.length();
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        
        int i = 0;
        while(i < n) {
            for (int row = 0; row < numRows && i < n; row++) sb[row].append(c[i++]);
            for (int row = numRows-2; row > 0 && i < n; row--) sb[row].append(c[i++]);
        }
        for (i = 1; i < sb.length; i++) sb[0].append(sb[i]);
        return sb[0].toString();            
    }
}