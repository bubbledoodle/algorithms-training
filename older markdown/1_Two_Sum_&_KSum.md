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

## K-SUM & thinkings
版本里整合一下K-Sum问题。和two-sum不同的是，这里两道题都返回所有值，which is a common senario. 去重将是一个很有意思的过程。这里采用的去重法则就是排序。排序过后跳过相同的数字。

几个别人代码有意思的地方

1. 命名 变量命名i j L R；或者是i L R 简洁清楚
2. 移动游子，L在最前，R在最右
3. 算出来len以后 每一次用到size只是一个memory access，而不是函数调用
4. 会用OJ的debuger了哈哈哈

### 3-sum code
```python
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        nums.sort()
        target = 0
        ans = []
        size = len(nums)
        
        for i in range(0, size - 2):
            if i and nums[i] == nums[i - 1]: continue 
            L, R = i + 1, size - 1
            target = 0
            curt_target = target - nums[i]
            while L < R:
                if nums[L] + nums[R] == curt_target:
                    ans.append([nums[i], nums[L], nums[R]])
                    L += 1
                    R -= 1
                    while L < R and nums[L] == nums[L - 1]: L += 1
                    while R > L and nums[R] == nums[R + 1]: R -= 1
                elif nums[L] + nums[R] > curt_target:
                    R -= 1
                else:
                    L += 1

        return ans
```

### 4-sum code
```python
class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        # print nums
        size = len(nums)
        ans = []
        
        for i in range(0, size - 3):
            if i and nums[i] == nums[i - 1]: continue
            secondP = i + 1
            
            # apart from 1st apply 3SUM
            for j in range(secondP, size - 2):
                if j > secondP and nums[j] == nums[j - 1]: continue
                thirdP, fourthP = j + 1, size - 1
                curent_tar = target - nums[i] - nums[j]
                while thirdP < fourthP:
                    # print i, j, thirdP, fourthP, curent_tar
                    if curent_tar == nums[thirdP] + nums[fourthP]:
                        ans.append([nums[i],nums[j],nums[thirdP],nums[fourthP]])
                        # print [nums[i],nums[j],nums[thirdP],nums[fourthP]] 
                        thirdP += 1
                        fourthP -= 1
                        while thirdP < fourthP and nums[thirdP] == nums[thirdP - 1]: thirdP += 1
                        while thirdP < fourthP and nums[fourthP] == nums[fourthP + 1]: fourthP -= 1
                    elif curent_tar > nums[thirdP] + nums[fourthP]:
                        thirdP += 1
                    else: fourthP -= 1
        return ans
```
