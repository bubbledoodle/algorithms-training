/*
## Description
Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

## Thinkings
2 things:
1. array contains repetition
2. k difference rather k sum
One of good trick is to sort the array first using Arrays.sort() O(nlogn) with ` for(int i=0; i<n; i++){
        if (i>0 && nums[i]==nums[i-1]) continue;`
the other trick is the right pointer. For the array is sorted, now don't have to consider the k different problem. 

*/
public class Solution {
    public int findPairs(int[] nums, int k) {
    if (k<0) return 0;
    Arrays.sort(nums);
    int n = nums.length, right = 0, count = 0;
    
    for(int i=0; i<n; i++){
        if (i>0 && nums[i]==nums[i-1]) continue;
        
        right = Math.max(right, i+1);
        while(right<n) {
            if(nums[right]-k == nums[i]) {
                count++;
                break;
            }
            else if (nums[right]-k < nums[i]) right++;
            else break;
        }    
    }
    return count;
    }
}
