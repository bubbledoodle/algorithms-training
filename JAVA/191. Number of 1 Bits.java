/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0, i = 0;
        while (i<32){
            res += n & 1;
            n = n>>>1;
            i++;
        }
        return res;
    }
}

/* Or more beautiful
In Java we need to put attention on the fact that the maximum integer is 2147483647. Integer type in Java is signed and there is no unsigned int. So the input 2147483648 is represented in Java as -2147483648 (in java int type has a cyclic representation, that means Integer.MAX_VALUE+1==Integer.MIN_VALUE).

1. unsigned >>>
2. n!=0 (in Java's logic, -128 ~ 1000 0000; while 127 ~ 0111 1111. 
3. Also about the complexity analysis: fixed length operation, O(1);


public static int hammingWeight(int n) {
	int ones = 0;
    	while(n!=0) {
    		ones = ones + (n & 1);
    		n = n>>>1;
    	}
    	return ones;
}

*/
