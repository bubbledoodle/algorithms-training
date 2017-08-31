// Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

// Example 1:
// Input: 
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7

// Target = 9

// Output: True
// Example 2:
// Input: 
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7

// Target = 28

// Output: False

// BST并没有被很好地利用，三中给出的答案都是traverse然后再去找2sum 没有新意。
// 不过讲真Hash来做本来就省去了search的过程，所以不见得利用BST的search功能会快
// that's it
// Also inorder traverse yeild a ascending array

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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return find(root, k, set);
    }
    private boolean find(TreeNode root, int k, HashSet<Integer> set){
        if(root == null) return false;
        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}