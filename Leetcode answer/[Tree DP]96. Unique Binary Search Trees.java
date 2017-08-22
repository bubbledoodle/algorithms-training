// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

// For example,
// Given n = 3, there are a total of 5 unique BST's.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3

// This is actually a finding pattern problem. 
// 选定一个root 比如要算dp[5] 选root = 1, left should be dp[0] and right should be dp[4] 1234 same combination as 2345
// due to combination, multiply dp[0] and dp[4] and proceed to root = 2.

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int level = 2; level <= n; level++){
            for(int root = 1; root <= level; root++){
                dp[level] += dp[root - 1]* dp[level - root];
            }
        }
        return dp[n];
    }
}