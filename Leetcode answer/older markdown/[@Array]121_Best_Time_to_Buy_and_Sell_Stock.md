## Question
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

## Code
```python
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        min, profit = None, 0
        for price in prices:
            if min == None:
                min = price
            elif min > price:
                min = price
            elif profit < price - min:
                profit = price - min
        return profit
```
## 出现的问题
最初想 要不要设置两个 flag，一个记大 一个记小。但是这样会出现问题记大的会卡在最大的，即便没有买入

所以问题解决方式是当有更低价格时，更新min（即买入）当有更大profit时 更新profit（即卖出最大值）
这个算法呢 不是实际操作，只能算出来理论最大值。
