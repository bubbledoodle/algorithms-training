Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
```python
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        candidate, count = None, 0
        for e in nums:
            if candidate == None:
                candidate, count = e, 1
            elif e == candidate:
                count += 1
            else:
                count -= 1
        return candidate
```
出现的问题：其实很巧妙地地方在于 "count -= 1" ,但感觉这样找不到多于 n/2 众数的时候会返回一个不是global最多的数字
自己傻的问题：1. 循环写错 2. 应该先判断初始条件 3. 赋值写在一行好看点
