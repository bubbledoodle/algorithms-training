/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
*/

/*
    no division 头一遍尾一遍 
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