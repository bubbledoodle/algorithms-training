/* 
## Description
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

## Thinkings
第一道Linked List(LL)的题熟悉一下这类LL题的套路
1. LL相较于Array 1. 增减新元素方便 O(1) 2. 元素的个数不固定 3.access O(n) worse then array.
2. the class: defined has val, next, and a constructor. 

3. 这道题呢，basically你不能知道前一个元素是什么，所以能做的是把下一个节点的东西copy到本节点，s.t.下一个节点没有reference。这样做的后果对于C会造成memory leak, while, JAVA will regard no reference node as garbage, then discard. 
4. copy 这里要分开做val和指针的。

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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
