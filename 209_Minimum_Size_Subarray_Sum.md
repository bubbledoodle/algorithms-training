## Question

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

## Code
```python
class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        start, end = 0, 0
        answer = len(nums)
        curt = s
        
        for i in range (0, len(nums)):
            curt -= nums[i]
            end = i
            while curt <= 0:
                curt += nums[start]
                start += 1
                if curt > 0:
                    start -= 1
                    curt -= nums[start]
                    answer = min(answer, end - start + 1)
                    break
                
        return [0, answer][curt <= 0]
        
 ```
 
 ## thinkings
