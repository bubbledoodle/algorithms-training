// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

// An example is the root-to-leaf path 1->2->3 which represents the number 123.

// Find the total sum of all root-to-leaf numbers.

// For example,

//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.

// Return the sum = 12 + 13 = 25.

// DFS递归经典
// 同时想到了level order，longest path

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumHelper(root, 0);
    }
    private int sumHelper(TreeNode root, int tempSum){
        if(root == null) return 0;
        if(root.right == null && root.left == null) return tempSum * 10 + root.val;
        return sumHelper(root.left, tempSum * 10 + root.val) + sumHelper(root.right, tempSum * 10 + root.val);
    }
}