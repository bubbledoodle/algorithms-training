## Question
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

## Code
Wrong code
```Java
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"}; // do not use new to create a new string
        HashMap<String, Integer> map = new HashMap();
        for(i = 0; i < strs.length; i++) {
            for(char c: strs[i].toCharArray()) {
                map.put(c,i);
            }
        }
        
        List res = new LinkedList<>();
        for(String w: words) {
            if (w==" ") continue;
            int index = map.get(c.toUpperCase().charAt(0)); // initial in loop condition
            for(char c: w.toUpperCase.toCharArray()) {
                if (map.get(c) != index) { index = -1; break;}
            }
            if (index != -1) res.add(w);
        }
        return res;
```

Corrected code
```Java
public class Solution {
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"}; // do not use new to create a new string
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < strs.length; i++) {
            for(char c: strs[i].toCharArray()) {
                map.put(c,i);
            }
        }
        
        List<String> res = new LinkedList<>();
        for(String w: words) {
            if (w==" ") continue;
            int index = map.get(w.toUpperCase().charAt(0)); // initial in loop condition
            for(char c: w.toUpperCase().toCharArray()) {
                if (map.get(c) != index) { index = -1; break;}
            }
            if (index != -1) res.add(w);
        }
        return res.toArray(new String[0]);
    }
}
```

## Thinkings

1. Most of problems comes from your language specification. Too bad in using JAVA now. Compile error mostly.
2. list it. you know then to create a String[]. To new a HashMap, String method toCharArray(), charAt(index), 
3. List<> is a interface which right now have no idea of what it is. 
4. In this example, String->Index. (fixed, char by char) word->{" ", "List of word"} -> {'list of chars'}
5. ez in algorithm
