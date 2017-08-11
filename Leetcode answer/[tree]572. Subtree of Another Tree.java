/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
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

/*
 frist need to traverse the tree s
 inner loop to traverse the tree t
 while traverse, perform isIdentical
*/
public class Solution {
    /* cant resolve [1,1] [1] test case
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (s.val == t.val) return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }*/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(isSame(s, t)) return true;
        return (isSubtree(s.left, t) || isSubtree(s.right, t));
    }
    
    public boolean isSame(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}