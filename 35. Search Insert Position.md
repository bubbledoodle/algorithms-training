## Question
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

## Code
```JAVA
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        int l=0, r=nums.length - 1;
        while(l <= r){
            int mid = (r + l)/2;
            if (target == nums[mid]) return mid;
            else if (target>nums[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
```
## Thinking
ez binary search
