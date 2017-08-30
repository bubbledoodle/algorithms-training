/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
*/

/*
    no division 头一遍尾一遍 
    明显看得出这道题上次是瞎做的。为什么这样头一遍尾一遍：
    头一遍保留了一个错位相乘，s.t.乘了int[index]之前的所有数。暂存在res里
    尾一遍同理又是一个错位相乘，在原有res[index]的基础上从尾部一直乘到index前一位
    所以就是头一遍尾一遍
*/


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if(n == 0) return res;
        int prefix = 1, suffix = 1;
        
        for (int i=0; i<n; i++) {
            res[i]  = prefix;
            prefix *= nums[i];
        }
        for (int i=n-1; i>=0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}