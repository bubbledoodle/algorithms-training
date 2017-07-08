/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

/*
 Interesting topic: DP problem
 自以为DP都可以看作是数列问题。由递推公式来求最优解问题
 既是最优化问题，DP就也免不了要用到Math.max这样的函数。一如此题：
 1. maintain three seq {nums} {robCurr} {notrob}
 2. 递推公式 recurrence:  rob[i] = 1 - notrob[i] mutual exclusive
                         notrob[i] = max{notrob[i - 1], rob[i - 1]} //以此决定这次不偷所得
                         rob[i] = notrob[i - 1] + nums[i]
                         而规条1出现在了后两条中 所以用到计算的seq只有两个，用到reference的数列有一个
 3， 为了只维持一个变量，不写明rob[i] notrob[i] 并引入一个游子来存 甚好！
*/


public class Solution {
    public int rob(int[] nums) {
        int robCurr = 0;
        int notRob = 0;
        for ( int n: nums) {
            int current = notRob + n;
            notRob = Math.max(notRob, robCurr);
            robCurr = current;
        }
        return Math.max(robCurr, notRob);
    }
}
