## Question
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

## Code
```JAVA
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s==null || p==null || s.length() < p.length()) return result;
        int[] charTable = new int[256];
        
        for(char c: p.toCharArray()){
            charTable[c]++;
        }
        
        int left=0, right=0, count=p.length();
        while(right<s.length()) {
            if (charTable[s.charAt(right)] >= 1){
                count--;
            }
            charTable[s.charAt(right)]--;
            right++;
            
            if (count==0) {
                result.add(left);
            }
            
            if ( right - left == p.length() ){
                if (charTable[s.charAt(left)] >= 0) {
                    count++;
                }
                charTable[s.charAt(left)]++;
                left++;
            }
        }
        return result;
    }
}
```

## Thinkings
1. sub-searching problem, slide window algorithm
2. ```for(char c: p.toCharArray()){
            charTable[c]++;
        }``` used for construct charTable or you call it hash
3. the idea of count is like to maintain how many you still expect
4. 2 entering condition inside the while
5. charTable not only used for maintain the used info, all other not used element also have minus(-) number indicate their not in p
6. matching process is reversed, like using p to match s. 
