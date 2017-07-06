/*
Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
*/


/*
 1. structual difference ---> 
 2. val difference ---> boolean res = (p.val == q.val) if (res == false) {break; return res;}
 3. any two difference happens, return flase and terminate the traversal immediately
 4. exactly same two tree, you have to traverse the entire tree. 
 
 --------------------
 \ @.@ nice question \
 --------------------
 
 actually set a res number is the worst way of solving the problem.
 use return to calcute and not to terminate the solution.
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) 
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
