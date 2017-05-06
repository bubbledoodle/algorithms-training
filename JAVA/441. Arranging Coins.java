/*
## Description 
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

## Thought
1. r*(r+1) = 2n;  r^2 + r - 2n =0 
2. Math.sqrt() Math.floor()
3. (int) 8L ... /2.0 Math problem all about precision 
*/

public class Solution {
    public int arrangeCoins(int n) {
        return (int) Math.floor((-1 + Math.sqrt(1 + 8L*n))/2.0);
    }
}
