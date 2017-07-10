/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

/*
 #Hash, #Two pointer, #String
 1. 好久不做hash生疏了
 2. 选用Set是并不需要map到别的东西
 3. 拉锯一样，扯到当前最长substring
*/



public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int res = 0, max = 0, j = 0, i = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max++;
                if(max > res) res = max;
            }
            else {
                max--;
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}