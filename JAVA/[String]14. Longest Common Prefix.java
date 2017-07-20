// Write a function to find the longest common prefix string amongst an array of strings.

/* 所有string一起最长的prefix
   会有一个loop走完全程，对比的时候可以用indexOf 再有while控制
   String Method: 1. 首先输入是一个list, 没有length() 而是length. 但每一个prefix是String，要用length()
                  2. indexOf
                  3. substring(begin, ending not inclusive);
*/


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            System.out.println(strs[i].indexOf(prefix));
            while (strs[i].indexOf(prefix) != 0) { // if all of prefix matches from begining, this number will be 0
                                                   // if doesn't match, return -1 and get into the while loop until match
                                                   // each time shorten one;
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }    
        }
        return prefix;
    }
}