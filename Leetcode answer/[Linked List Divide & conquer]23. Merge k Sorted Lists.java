// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
// 在这个之前先要写出来merge两个LL的
// 然后可以并行可以像这样divide & conquer(binary search的)来划分剩余的工作量 别作乱了

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }
    
    private static ListNode partion(ListNode[] lists, int start, int end){
        if(start == end)  return lists[start];
        if(start < end){
            int mid = (start + end) / 2;
            ListNode l1 = partion(lists, start, mid);
            ListNode l2 = partion(lists, mid + 1, end);
            return merge(l1,l2);
        }else
        return null;
    }
    
    public static ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            //缝合是在下边这一行，有return ListNode merge 完了以后并不是一个巨大的LL而是一个缝合好的LL
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}