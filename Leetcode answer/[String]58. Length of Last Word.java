/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

// not funny at all. 
// trim();
// lastIndexOf(' ')

public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // removing head and tail ' '
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;  
    }
}