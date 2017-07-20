/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/


/*
    classic Backtracking problem
    difference: 1. private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
                2. String letters = KEYS[(digits.charAt(offset) - '0')]; use this to retreive in String Array
*/


public class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return res;
        combination("", digits, 0, res);
        return res;
    }
    private void combination(String prefix, String digits, int offset, List<String> res) {
        if (offset >= digits.length()) {
            res.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for(int i=0; i<letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, res);   
        }
    }
}