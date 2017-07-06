/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
Example:
Given a = 1 and b = 2, return 3.


*/

/*
first need to figure out to use the bit manipulation 
then draw a bit to compute --- > know to use rescursion
finally, you find out to use the if statement at the begining. 
*/



public class Solution {
    public int getSum(int a, int b) {
        if (b == 0) return a;
        int s = a^b, c = (a&b)<<1;
        return getSum(s, c);
    }
}
