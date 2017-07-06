/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.
Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[5,6]
*/

/*

Impressive. there is one hidden hash function created using the indexing as mapping method.
The main job for hash table is to create difference to elements. 
BY ADDING N to each of existing indexing numbers, those <= n will be the 'indexing' or more specifically the number missing in the list.

//List<Integer> = new ArrayList<>();


*/


public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i<n; i++) nums[(nums[i] - 1) % n] += n;
        for (int i = 0; i<n; i++) if(nums[i] <= n) res.add(i+1);
        return res;
    }
}
