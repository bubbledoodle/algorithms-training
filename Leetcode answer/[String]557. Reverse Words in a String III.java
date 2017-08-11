/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*/

// 1. do not scared by any string manipulation questions.
// 2. reverseWords, the while statement is well polished for all edge conditions.
// 3. thinking of using an additional methods need to input ch and two flags.
// 4. in Java, the change in ch directly mapped to words in memory, so no return type in reverse function needed
//
// Methods and return:
// toCharArray()
// length()
// return new String(ch) // force type change.


public class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        
        for (int i=0; i<ch.length; i++) {
            if(ch[i] != ' ') {
                int j = i;
                while (j + 1 < ch.length && ch[j + 1] != ' ') j++;
                reverse(ch, i, j);
                i = j;
            }
        }
        return new String(ch);
    }
    
    public void reverse(char[] ch, int i, int j) {
        while(i<j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++; j--;
        }
    }
}
