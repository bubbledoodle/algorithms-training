// Determine whether an integer is a palindrome. Do this without extra space.


/*
 1. 一者把除掉的数重构成另一个数
 2. 另一面慢慢把x变小。对比
*/
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || x % 10 == 0 && x != 0) return false;
        int reconstruct = 0;
        while(x > reconstruct) {
            reconstruct = reconstruct * 10 + x % 10;
            x = x/10;
        }
        return (x == reconstruct || x == reconstruct / 10);
    }
}