/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
*/

/*
  掐头去尾
  Arrays.sort()
  .clone()
*/


public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        
        int start = 0, end = n - 1;
        while(start < n && temp[start] == nums[start]) start++;
        while(end > start && temp[end] == nums[end]) end--;
        return end - start + 1;
        
    }
}