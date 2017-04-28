/*
## Description Write a function that takes a string as input and returns the string reversed.
## Caution: 1. to make a char array to string, return `new String(word);`
            2. ez, no more saying
*/

public class Solution {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int n = s.length();
        for(int i=0; i<n/2; i++){
            char temp = word[i];
            word[i] = word[n-i-1];
            word[n-i-1] = temp;
        }
        return new String(word);
    }
}
