## Question
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
Note:
You may assume the string contains only lowercase alphabets.

## Code
```JAVA
public class Solution {
    public boolean isAnagram(String s, String t) {
        int ns = s.length(), nt = t.length();
        int[] alphabet = new int[26];
        for (int i=0; i<ns; i++) alphabet[s.charAt(i) - 'a'] += 1;
        for (int i=0; i<nt; i++) alphabet[t.charAt(i) - 'a'] -= 1;
        for (int i: alphabet) if (i!=0) return false;
        return true;
    }
}
```

## Thinking
Oh, very similar to [205 Isomorphic Strings](https://github.com/bubbledoodle/Algorithms_Training/blob/master/205.%20Isomorphic%20Strings.md). 
Let's talk about why can't use HashMap. 
1. Creating 2 HashMap actually causes mapping problem, which is not actually HashMap designed for.
2. For HashMap the map.getArray() method could be used to extract array, however not too many case for this as you may already into a very strange thought.
