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
今天看了DP问题，那么回头拿来这道题再看就不是那么困难了。有两个点需要注意，也是卡住的地方。一个是初始化的时候，max和min一个初始化成num[0] 另一个初始化成0。另一个问题是在更新每一个entry的时候。有一个是正常的更新。另一个为了记录 比方说min就是为了记录更小的负数。而max的话可能会用0来开始下一个list

那么就涉及到另一个问题，其实你需要第三张表来记录
