/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

/*
 叙事一样

*/

public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            int temp = res * 10 + tail;
            if ((temp - tail) / 10 != res) return 0;
            res = temp;
            x = x/10;
        }
        return res;
    }
}