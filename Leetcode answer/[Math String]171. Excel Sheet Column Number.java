// Related to question Excel Sheet Column Title

// Given a column title as appear in an Excel sheet, return its corresponding column number.

// For example:

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 

// 姊妹篇 其实charAt就可以了 用不着toCharArray
// 知道我们的十进制数是怎么来的：先乘后加嘛


class Solution {
    public int titleToNumber(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            res *= 26;
            res += (int)(ch[i] - 'A' + 1);
        }
        return res;
    }
}