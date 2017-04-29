/*
## Description
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

## Thinkings
1. the corner condition start <= end is used otherthen only <, in the thought of single element
2. Character.isLetterOrDigit() method is utilized. 

*/



public class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int start = 0, end = n - 1;
        s = s.toUpperCase();
        while(start <= end) {
            //find next start char
            while(start<=end && !Character.isLetterOrDigit(s.charAt(start))) start++; //!((s.charAt(start)>=65 && s.charAt(start)<=90)||(s.charAt(start)>=30 && s.charAt(start)<=39))) start++;
            //find next end char
            while(start<=end &&!Character.isLetterOrDigit(s.charAt(end))) end--; //!((s.charAt(start)>=65 && s.charAt(start)<=90)||(s.charAt(start)>=30 && s.charAt(start)<=39))) end--;
            //compare

            if(start <= end && s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
