/**
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.



 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 // Traversal of tree in-order;
 // This example heavily uses Java ternary, which heavily shorten the coding length.
 // Traversal key point is to judge if the root is null or not. That is the very first line should be written down.
 // mergeTrees takes two input node, either as null or the true value. 
 // one thing should notice is that, each recursion time, you have to push the node moving down unless both t1 and t2 are all terminated, which is specified in the first if statement. 
 
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newRoot = new TreeNode(val);
        
        newRoot.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newRoot.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        
        return newRoot;
    }
}
