## question
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

## Code

```Java
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while(left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > middle) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
```

## thinkings

1. first time touching Java array. Arrays.API; nums.length accessing etc
2. math solution is funny, add up, minus interesting.
3. BS conventional ways of solving problem. some point gotta know. two pointer, one from start, one ending. search and update.
4. you gotta know the left one is updated to middle + 1. It is the problem nature. 
