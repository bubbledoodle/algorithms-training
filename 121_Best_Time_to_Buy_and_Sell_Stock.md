## Question
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

## Code
```
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
        
