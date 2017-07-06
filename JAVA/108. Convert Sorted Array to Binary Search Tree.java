//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

/*
 1. hight balanced, need to start root at the center
 2. two pointer is not enough, need logn pointers
 
---------------
 @.@ nice one
---------------
 1. 要写另外一个函数的必要性 来自于题目规定了只有一个输入的sortedArrayToBST method
 2. 不像一开始想的，并不需要n pointer, 事实上也从来没有n pointer的问题。 
 3. 构造的trans函数输入决定了trans工作的范围 所以要有两端的index
 4. 入口始终是left<=right, 取反为返回null条件
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = trans(nums, 0, nums.length - 1);
        return root;
    }
    
    public TreeNode trans(int[] nums, int left, int right){
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = trans(nums, left, mid - 1);
        root.right = trans(nums, mid + 1, right);
        return root;
    }
    
}
