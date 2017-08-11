/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
*/

/*
Trick to this is the input p q will never have the same parent except the first layer. 
why? 
check out here: isMirror(p.left,q.right) && isMirror(p.right,q.left);
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
        
    }
    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }
}


/* This is not right, for the question asking is not the totally symmetric but the level based symmetric
   so the best way to do is to perform a level based traverse.
        if (root.left == null && root.right == null) return true;
        else if (root.left == null || root.right == null) return false;
        else if (root.left.val != root.right.val) return false;
        return isSymmetric(root.left) && isSymmetric(root.right);
*/
