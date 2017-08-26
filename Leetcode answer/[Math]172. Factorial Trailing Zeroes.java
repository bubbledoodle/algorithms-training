// Given an integer n, return the number of trailing zeroes in n!.

// Note: Your solution should be in logarithmic time complexity.

// This is smart return n/5 + n/25 + n/125 + n/625 + n/3125+...;

class Solution {
    public int trailingZeroes(int n) {
        // counting 5
        int res = 0;
        while(n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}