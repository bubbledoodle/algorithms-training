// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

// 关键点在最后一行return处。怎么想肯定是DFS先到达最远的叶子节点（无所谓用了pre in post）逃逸条件root == null. 最后 return处 left right 有一个等于空 算深度要算另一侧的。反之两侧都有的时候比较哪一侧比较浅 返回之


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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}