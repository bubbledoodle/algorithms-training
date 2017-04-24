## Question
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 
## code
```python
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        prev, profit = None, 0
        for price in prices:
            if prev == None:
                prev = price
            elif prev > price:
                prev = price
            elif prev < price:
                profit += price - prev
                prev = price
        return profit
```

别人的代码 array access 逻辑也清楚很多 just a measurement, not operation. your code is wrong in logic, well not 100% wrong but 如果说判断prev > price 会更新prev 但是不符合买卖规则呀。哎 其实他的代码也一样
```python
        profit = 0
        for i in range(1, len(prices)):
            diff = prices[i] - prices[i - 1]
            if diff > 0:
                profit += diff
        return profit
```
## thinkings
人家说用到了贪心算法，开始我也是想麻烦了的那种

[5, 1, 2, 3, 4]中的1, 2, 3, 4序列来说，对于两种操作方案：
1 在1买入，4卖出
2 在1买入，2卖出同时买入，3卖出同时买入，4卖出。这两种操作下，收益是一样的。


去搜了一下贪心，要满足一个无后效性，也就是当前选择只会影响当前。想这个问题我卖出的同时买入，相当于我手上还有这个股票。但是不是卖出（计入到profit里）相当于对于最终的profit有一个递进的功能。 5 1 2 6 4 2 7 3 按照这样应该是 1入2出2入6出 2入7出。 每一次涨都被记录在了profit里做贪心一部分。和现实不符合的是能看到跌，这个就不算买了
