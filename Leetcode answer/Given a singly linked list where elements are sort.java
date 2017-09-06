// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

// 和从sorted array 到 BST思想一样，也是要找到中间作为root分离两边递归。LL找中间的方法就是用快慢指针。
// 这个题快慢指针走到中间以后要打破原先的LL从而下一次递归的时候才可以让LL起始点确定

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            TreeNode root = new TreeNode(head.val);
            return root;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.next.val);
        ListNode newHead = slow.next.next;
        slow.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(newHead);
        return root;
    }
}