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
    // method 1 pass res as argument
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

    // method 2 new an ArrayList everytime

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    // method 3 stack: Stack<TreeNode> tovisit = new Stack<TreeNode>();
    // .push() .pop() .empty()
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> tovisit = new Stack<TreeNode>();
        tovisit.push(root);
        while(!tovisit.empty()) {
            TreeNode node = tovisit.pop();
            res.add(node.val);
            if(node.right != null) tovisit.push(node.right);
            if(node.left != null) tovisit.push(node.left);
        }
        return res;
    }
}