// A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that num[-1] = num[n] = -∞.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.


// 言而总之 find the local maximum
// binary的找同样是只比较连续的两个数的大小
// binary的复杂度分析：时间上每次缩小搜索范围一倍，所以O(logN) 空间上调用了logN次函数，所以进栈的空间为O(logN)


class Solution {
    
    // O(logN)
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int start, int end){
        if(start == end){
            return start;
        } else {
            int mid = (start + end) / 2;
            if(nums[mid] > nums[mid + 1])
                return helper(nums, start, mid);
            else
                return helper(nums, mid + 1, end);
        }
    }
    
    
    // O(N)
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                return i;
            }
        }
        return nums.length - 1;
    }
}