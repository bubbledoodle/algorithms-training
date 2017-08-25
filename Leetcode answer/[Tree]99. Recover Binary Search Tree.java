// Two elements of a binary search tree (BST) are swapped by mistake.

// Recover the tree without changing its structure.

// BST的inorder traverse是一个排好序的数组
// 利用这一条 先写一个inorder的traverse 中间变成//TODOs
// 要做的：找到两个乱序的元素，交换他们的值。maintain一个prevElement指针，这个指针初始化为MIN_VALUE
// 为了递归简便，定义成了全局变量


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
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = secondElement.val;
        secondElement.val = firstElement.val;
        firstElement.val = temp;
    }
    private void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
            
        prevElement = root;
        traverse(root.right);
    }
    
    
}