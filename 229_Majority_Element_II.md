## Question
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
## reference code
```python
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n1, n2, c1, c2 = None, None, 0, 0
        for num in nums:
            if n1 == num:
                c1 += 1
            elif n2 == num: 
                c2 += 1
            elif c1 == 0:
                n1, c1 = num, 1
            elif c2 == 0:
                n2, c2 = num, 1

            else:
                c1 -= 1
                c2 -= 1
        size = len(nums)
        return [n for n in (n1, n2) if n is not None and nums.count(n) > size / 3]    
```
## 出现的问题：
看过hint之后多于1/3的数要记录那应该是有至多两个，想成三个了。另外针对想的如果vote算法只减一个会造成计数不对等，那实际上操作也是这样，同时减嘛
return是第一个比较tricky的地方，提上没有说一定存在这样的数字，所以 return里带有if判断了
五个if的顺序比较6，首先判断一定不是先c1的所有再c2 思考一下，我们记完一个数以后希望就move on到下一个数了，依照consistancy 思考两个数, 若果相同我们希望只记在一个c里，如果不同 我们希望分别记录(针对是前两个数) 也就是说，hit `c1 == 0` 之后一定要先hit `n1 == num` 而不能先hit `c2 == 0` 同理 c2的。也就是说这一次的入口条件是先看有没有 再去判断是不是初值。
程序不太好的地方：最后竟然用了count函数，感觉怪怪的
