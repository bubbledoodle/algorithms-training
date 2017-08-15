## 一题一句话
1. [237. Delete Node in a Linked List] [no tail delete; no prev reference] 
```JAVA
curr.val = curr.next.val 
curr.next = curr.next.next
```

2. [206. Reverse Linked List][basic op] because need reverse, need: prev, curr, curr.next
```JAVA
temp = curr.next;
curr.next = prev; // reverse pointer
prev = curr; // shift right 
curr = temp;
```

3. [234. Palindrome Linked List] [middle cut; two pointer; reverse] the best way to __go into the middle of LL__ is to use two pointer as `slow = slow.next` & `fast = fast.next.next`. Notice the __loop condition__ shoule be `while(fast!=null && fast.next!=null)` for secure two reference prevent JAVA throw outOfBound panic<could be this>

4. [203. Remove Linked List Elements] [regular delete; fakeHead] for regular delete an element, you have to access to prev node. which here introduce fakeHead trick. init a fakeHead using new as `ListNode fakeHead = new ListNode(-1);`

5. [160. Intersection of Two Linked Lists] 对齐对齐， compare reference of node.
6. [141. Linked List Cycle] [Search; or two pointer] HashSet<ListNode>; or slow fast pointer
7. [83. Remove Duplicates from Sorted List] [LL; Duplicate; Sorted] Duplicate --> Hash; Sorted --> near element compare
8. [21. Merge Two Sorted Lists] [no explit loop ending condition] this result in recursion. init the node trick, here to null.

## Linked List convention
1. new `ListNode fakeHead = new ListNode(-1)`
2. Class include constructor, pointer, val
3. pointer could be used to point to any position
4. 'temp = temp.next' is the way to move on pointers, whereas `temp.next = balahbalah` is the way to update pointer,
