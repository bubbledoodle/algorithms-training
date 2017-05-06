/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

## Thought 
1. binary search: need to remember left, mid, right setting
2. to prevent overflow, use long mid, use >>> unsigned shift right
3. increamented binary search could be faster
*/


public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<0) return false;
        int left = 0, right = num;
        while(left <= right){
            long mid = (left + right) >>> 1;
            if (mid*mid == num) return true;
            else if (mid*mid > num) right = (int) mid - 1;
            else left = (int) mid + 1;
        }
        return false;
    }
}

/* This is interesting. Perfect squares are all 1 + 3 + 5 + 7...
public boolean isPerfectSquare(int num) {
     int i = 1;
     while (num > 0) {
         num -= i;
         i += 2;
     }
     return num == 0;
 }
*/
