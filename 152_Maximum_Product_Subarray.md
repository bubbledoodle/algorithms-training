## Question
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

## two versions of code

```python
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # initialization
        size = len(nums)
        if size == 0:
            ans = []
        else:
            ans = nums[0]
        
        maxplus = [0 for i in range(size)]
        minminus = [0 for i in range(size)]
        
        if nums[0] > 0:
            maxplus[0] = nums[0]
        else:
            minminus[0] = nums[0]

        # traverse
        for i in range(1, size):
            if nums[i] > 0:
                if nums[i] > maxplus[i-1] * nums[i]:
                    maxplus[i] = nums[i]
                else:
                    maxplus[i] = maxplus[i-1] * nums[i]
                minminus[i] = minminus[i-1] * nums[i]
            else:
                if nums[i] <  maxplus[i-1] * nums[i]:
                    minminus[i] = nums[i]
                else:
                    minminus[i] = maxplus[i-1] * nums[i]
                maxplus[i] = minminus[i-1] * nums[i]
            if maxplus[i] > ans:
                ans = maxplus[i]
                               
        """ second edition
        maxMul = minMul = ans = nums[0]
        
        for i in range(1,len(nums)):
            t = maxMul
            maxMul = max(t * nums[i], minMul * nums[i], nums[i])
            minMul = min(t * nums[i], minMul * nums[i], nums[i])
            ans = max(maxMul, ans)
        """
        return ans
```

## thinking:
今天
