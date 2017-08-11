/*
## Description
Given a singly linked list, determine if it is a palindrome.

## Thinkings
有人说O(1)的做法不可能达到，还分析Reversing a list is not considered "O(1) space" 说的在理。
1. 想对了一半，reverse LL 另一半：对于这种对称的题很常见__fast和slow__ pointer一起走 这里的pointer其实就是ListNode
2. head不能丢，有head有天下
3. 判断等 其实就是 .val == .val 的动作
4. reverse给进去的是head 返回一个head其实已经反向过了
5. JAVA没有while(head)这样的python写法
6. LL因为没有index access，这里while会用很多

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = reverse(slow); 
        fast = head; // head 不能丢
        while(slow!=null){
            if (slow.val != fast.val) return false; //
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null){ //
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
