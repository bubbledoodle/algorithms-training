// 以下的一组题都是关于maximum subarray的问题。不同的题设，放在这里，以作对比


// 121. Best Time to Buy and Sell Stock
// you can only buy and sell once during the entire period.
public class Solution {
    /* // little bit logically not clear, but essentially doing the same job.
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0; int in = 0;
        for (int i = 0; i< prices.length; i++) {
            if (prices[i]>prices[in]) res = Math.max(res, prices[i] - prices[in]);
            else in = i;
        }
        return res;
    }
    */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            if(prices[i] < minPrice) minPrice = prices[i];
            else if(maxProfit < prices[i] - minPrice) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}

// 122. Best Time to Buy and Sell Stock II
// you can buy and sell multiple times. 

// 3 stages of thinking. brute force... > logically find peak and valley, then add them up. 
// finding a peak and valley is to perform the comparasion between 2 consecutive elements
// like prices[i]<prices[i+1] > will be valley, vice peak

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i=0; i< prices.length - 1; i++) {
            if (prices[i]<prices[i+1]) profit += prices[i+1] - prices[i];
        }
        return profit;
    }
}


// [DP] 309. Best Time to Buy and Sell Stock with Cooldown
//After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

/*
            rest
    rest s0 <------ s2
          \        /
           \      /
        buy \    / sell
             \  /
              s2
            rest
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;
        int[] s0 = new int[n];
        int[] s1 = new int[n];
        int[] s2 = new int[n];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i=1; i<n; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i]);
            s2[i] = s1[i-1] + prices[i];
        }
        return Math.max(s0[n-1], s2[n-1]);
    }
}