## question
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

## code
```python
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i, num in enumerate(nums):
            for j in range(i + 1, len(nums)):
                if target - num == nums[j]:
                    return [i, j]
```

## thinking
K Sum类型问题的初级版本。

最朴素的方法是，枚举第一个数，枚举第二个数，这样复杂度O(n^2)。 
如何更好？binary search，枚举第一个数x，然后第二个数为target – x，在数组中查找（需要先排序），复杂度O(nlogn)。
当然，如果把数组排好序，更好的方法是，直接双指针（接下来你会在3sum 4sum啥的看到类似的解法）。
最好的方法是直接hash。 把每个数作为key,下标作为值，放入hash表，然后遍历的时候找target – x。【本code采用的方法】

其实看了很多遍hash终于有点眉目。hash很抽象，所有那些映射的东西都可以叫做hash。weather you made any change in raw data or not. 
