// Given a binary tree, return the preorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,2,3].

// 这个helper function的套路已熟悉 看一个stack的吧

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    
    private void helper(List<Integer> list, TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        helper(list, root.left);
        helper(list, root.right);
    }
}