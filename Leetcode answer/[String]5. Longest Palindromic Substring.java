// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

// Example:

// Input: "babad"

// Output: "bab"

// Note: "aba" is also a valid answer.
// Example:

// Input: "cbbd"

// Output: "bb"


// 从中心向两边的展开过程。
// dp的部分想好边界条件，j>=i 和dp前序的j - 1 >= i + 1

class Solution {
    
    // method 1
    private int left, maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        for(int i = 0; i < len - 1; i++){
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(left, left + maxLen);
    }
    private void extend(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if (maxLen < r - l - 1) {
            left = l + 1;
            maxLen = r - l - 1;
        }
    }
    
    // method 2
    public String longestPalindrome(String s){
        int len = s.length();
        String res = null;
        
        boolean dp[][] = new boolean[len][len];
        for (int j = 0; j < len; j++){
            for (int i = 0; i <= j; i++){
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
                //System.out.printf("i = %d,j = %d, dp[i][j] = %B\n", i, j, dp[i][j]);
                 if (dp[i][j] && (res == null || j - i + 1 > res.length())){
                    res = s.substring(i, j + 1);
                }
                
            }
            
        }
        return res;
    }
}