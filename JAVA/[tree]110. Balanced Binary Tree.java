/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


*/

/*
 Two step: 
 1. know how to get the depth of subtree
 2. main recursion happens in isBalanced method
 Top down approach will cause the complexity at O(n^2) while calling depth will cause O(n)
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

/* O(n^2)
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(depth(root.left) - depth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
        
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

*/

// O(n) bottom-up method usingi Depth First Search (DFS) tree
// notice to compute and store the value into variable, in order to avoid further recursion.
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    public int dfsHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = dfsHeight(root.left);
        int rightHeight = dfsHeight(root.right);
        if ( leftHeight == -1) return -1;
        if ( rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // ensure those enter this step's right and left are balanced. 
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

