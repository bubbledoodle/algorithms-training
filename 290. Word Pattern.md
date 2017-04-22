## Question 
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

## Code 
```JAVA
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        int n = words.length;
        int m = pattern.length();
        if (n!=m) return false;
        for (int i=0; i<n; i++) {
            if(map.containsKey(pattern.charAt(i))) {
                if (map.get(pattern.charAt(i)).equals(words[i]))  continue;
                else return false;
            } else {
                if (map.containsValue(words[i])) return false; // this word has already been map to other char.
                map.put(pattern.charAt(i),words[i]);
            }
        }
        return true;
    }
}
```

## Thinking
1. Split(' ') 和 equals() method 大大缩小了这个题的难度。
2. several String method .split() .equals() .charAt() .length()
3. HashMap<Character, String>
