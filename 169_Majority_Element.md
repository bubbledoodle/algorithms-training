## Question
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

## Reference Code --- Vote algorithm
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
出现的问题：其实很巧妙地地方在于 `count -= 1` ,但感觉这样找不到多于 n/2 众数的时候会返回一个不是global最多的数字
自己傻的问题：1. 循环写错 2. 应该先判断初始条件 3. 赋值写在一行好看点

## 以下列出几种不同的方法
时间复杂度: O(n2) — 蛮力法: 依次检查每一个元素是否为众数

时间复杂度: O(n), 空间复杂度: O(n) — 哈希表: 维护一个每一个元素出现次数的哈希表, 然后找到出现次数最多的元素

时间复杂度: O(n log n) — 排序: 在排序后找出连续重复出现次数最多的元素

平均时间复杂度: O(n), 最坏复杂度: 无穷大 — 随机算法: 随机选取一个元素计算其是否为众数. 如果不是, 就重复上一步骤直到找到为止。 由于选出众数的概率 > 1 / 2, 因此期望的尝试次数 < 2

时间复杂度: O(n log n) — 分治法: 将数组拆成2半, 然后找出前一半的众数A和后一半的众数B。则全局众数要么是A要么是B。 如果 A == B, 则它自然而然就是全局众数。 如果不是, 则A和B都是候选众数, 则至多只需要检查这两个元素的出现次数即可。 时间复杂度, T(n) = T(n/2) + 2n = O(n log n).

时间复杂度: O(n) — Moore投票算法: 我们维护一个当前的候选众数和一个初始为0的计数器。遍历数组时，我们看当前的元素x:

如果计数器是0, 我们将候选众数置为 x 并将计数器置为 1
如果计数器非0, 我们根据x与当前的候选众数是否相等对计数器+1或者-1
一趟之后, 当前的候选众数就是所求众数. 时间复杂度 = O(n).
时间复杂度: O(n) — 位操作法: 我们需要32次迭代, 每一次计算所有n个数的第i位的1的个数。由于众数一定存在，那么或者1的个数 > 0的个数 或者反过来(但绝不会相同)。 众数的第i位一定是计数较多数字。
