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
这段代码写的不顺，滑窗的想法对了，而且这个减得方法想的也很好。O(n)时间复杂度。渐渐发现复杂度这个东西，和遍历方式，设计算法有关，和for什么的细化的每一个循环并没那么大关系
遇到的问题吧：从后往前 return那里知得借鉴python的返回值方式。answer的一个0比较让代码干净了很多
