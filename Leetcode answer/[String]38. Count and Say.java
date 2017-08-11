// The count-and-say sequence is the sequence of integers with the first five terms as following:

// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth term of the count-and-say sequence.

// Note: Each term of the sequence of integers will be represented as a string.

// 道：
// There is no direct way to compute the result. All strings has to be generated, which is some dynamic Strings in for loop.
// 术：
// At each time, count and generate sb.append(count + "" + s.charAt(j));




public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return null;
        String s = "1";
        for(int i = 1; i < n; i++){
            int count = 1;
            StringBuilder sb = new StringBuilder();
            int slen = s.length();
            for(int j = 0; j < slen; j++){
                if(j < slen - 1 && s.charAt(j) == s.charAt(j + 1)){
                    count++;
                } else {
                    sb.append(count + "" + s.charAt(j));
                    count = 1;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}