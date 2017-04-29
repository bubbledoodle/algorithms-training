/*
## Description
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

## Thinkings
1. How to new a HashSet with certain element
   i. HasSet<Character> set = new HashSet(vowels.length);
   ii. 事实证明，把init HashSet 的过程扔到外边， 对于这个计时系统来说不起作用
2. write a pseudocode before actually hands on helps
3. HashSet shorten the search time to O(1) with .contains() method
4. String's two pointer convention: s.toCharArray --> mulnipulation --> return new String(word);
*/

public class Solution {
    private static HashSet<Character> set = new HashSet<>();
    
    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');        
    }
    
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int n = s.length();
        /*
        HashSet<Character> set = new HashSet<Character>(10);
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        */
        
        int i = 0, j = n - 1;
        while(i<j) { // cannot use for loop here
            // find i next vowel
            while(i<j && !set.contains(word[i])) i++;
            // find j next vowel
            while(i<j && !set.contains(word[j])) j--;
            
            // swap
            char temp = word[j];
            word[j] = word[i];
            word[i] = temp;
            // increament;
            i++;
            j--;
        }
        return new String(word);
    }
}
