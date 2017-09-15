// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.

// 1. pq
// 2. quickSort
// 3. quickSort advanced


 
// What is quick sort?
// basically: divid & conquer/ pivot is set to move all smaller then it to its left, all larger to its right.

// 


class Solution {
    // // PriorityQueue O(nlogk)
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for(int num: nums){
    //         pq.offer(num);
    //         if(pq.size() > k) pq.poll();
    //     }
    //     return pq.poll();
    // }
    
    // quick sort
    
    //     public int findKthLargest(int[] nums, int k) {
    //        return helper(nums, 0, nums.length - 1, nums.length - k); 
    //     }    
    //     private int helper(int[] nums, int low, int high, int k){
    //         int pivot = nums[high];
    //         int wall = low;
            
    //         for (int i = low; i < high; i++){
    //             if(nums[i] <= pivot){
    //                 swap(nums, i, wall);
    //                 wall++;
    //             }
    //         }
    //         swap(nums, wall, high);
            
    //         if(wall == k) return nums[wall];
    //         else if(wall > k) return helper(nums, low, wall - 1,k);
    //         else return helper(nums, wall + 1, high, k);
    //     }
        
    //     private void swap(int[] nums, int a, int b){
    //         int temp = nums[a];
    //         nums[a] = nums[b];
    //         nums[b] = temp;
    //     }

    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }
    
    public int helper(int[] nums, int start, int end, int target) {
        if (start == end) return nums[start];
        int pivot = nums[(start + (end - start) / 2)];
        int left = start;
        int right = end;
        while (left <= right) {
            while (nums[left] > pivot) {
                left++;
            }
            while (nums[right] < pivot) {
                right--;
            }

            if (left <= right) {//
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        // if (left < target) return helper(nums, left + 1, end, target - left + start);
        // if (right > target) return helper(nums, start, right, target);
        if (target + start - 1 >= left) return helper(nums, left, end, target - left + start);
        if (target + start - 1 <= right) return helper(nums, start, right, target);
        return nums[right + 1];
    }

}