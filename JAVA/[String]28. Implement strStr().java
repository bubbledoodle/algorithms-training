/*
## Description 
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

##
Thinkings
Thinkof slide window is good. the difference is the brute force uses start point as iteration, while yours choose ending point.
you have to do exhausted search here. otherwise gonna miss. 

some algorithm learned at EL737 could be useful, however, complex to reach better performance. 
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        
        // brute force. Method I
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i+j)) break;
            }
        }

/*      // I don't like this following method. Method II

        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; i++) {
            if (haystack.substring(i,i+l2).equals(needle)) { // ez as shit logic
                return i;
            }
        }
        return -1;
*/

        /* WRONG ANS
        // not beautiful part: 
        1. naming, length just use l1, l2 plz
        2. here needless to dig into detail of each char. 
        
        if (haystack==null || needle==null || haystack.length() < needle.length()) return -1;
        if (needle.length()==0) return 0;
        //basic idea sub-search. should use sliding window
        int start = 0, end = 0, curr = 0;
        char[] wordsH = haystack.toCharArray();
        char[] wordsN = needle.toCharArray();
        int lengthH = haystack.length();
        int lengthN = needle.length();
        int count = lengthN;
        
        while(end<lengthH) {
            if (wordsH[end] == wordsN[curr]){
                count--;
                curr++;
                end++;
            } else {
                count = lengthN;
                curr = 0;
                end++;
                start = end; // can not jump like this. to jump the start directly to end. then give up this idea. 
            }
            
            if(count==0){
                return start;
            }
            //System.out.printf("start = %s end = %s curr = %s\n", wordsH[start], wordsH[end], wordsN[curr]);
        }
        return -1;
        */
    }
}
