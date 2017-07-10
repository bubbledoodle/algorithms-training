//Implement pow(x, n).

/*
 1. log(n)
 2. notice n < 0 case. Java int from -2^31 ~ 2^31 - 1
 3. 区分对待奇偶次方
*/


public class Solution {
    public double myPow(double x, int n) {
        if(n < 0) return 1/x * myPow(1/x, -(n + 1));
        if(n == 0) return 1;
        if(n == 2) return x*x;
        if(n % 2 == 0) return myPow(myPow(x, n/2), 2);
        else return x*myPow(myPow(x, n/2), 2);
    }
}