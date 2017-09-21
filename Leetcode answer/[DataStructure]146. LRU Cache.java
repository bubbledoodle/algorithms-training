// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

// Follow up:
// Could you do both operations in O(1) time complexity?

// Example:

// LRUCache cache = new LRUCache( 2 /* capacity */ );

// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.put(4, 4);    // evicts key 1
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4



// LRU 按照时间顺序排列的缓存， 距离上一次活跃时间最久的元素将要被清除。
// 思考数据结构，由于要求两种操作都在O(1)内完成，而且这两种操作涉及到两个元操作：删除点() 添加到队头()
// 本来想用queue，但是queue或单向链表没有办法达到O(1)的访问和删除复杂度。
// --->想到使用双向链表可以完美达到要求 O(1)的访问和删除复杂度。需要单独的写出来一个class
// 为了保证有且只有一个相同的元素在队中，使用map来计哪个元素出现过
// get()操作：有出现，刷新访问时间(即删掉再放在队头)； 找不到就返回 -1
// put()操作：有出现，说明不溢出，直接和get相似操作，注意更新value； 没有出现要判断有无溢出


class LRUCache {
    private int capacity, count;
    private HashMap<Integer, Node> map;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.next = null;
        head.prev = null;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;//顺序到底有没有影响
    }
    
    public int get(int key) {
        if (map.get(key) != null){
            Node node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.get(key) != null){
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addToHead(node);
        } else {
            if(count < capacity){
                Node node = new Node(key, value);
                addToHead(node);
                map.put(key, node);
                count++;
            } else {
                map.remove(tail.prev.key); // clear map info
                deleteNode(tail.prev);
                Node node = new Node(key, value);
                addToHead(node);
                map.put(key, node);
            }
        }
    }
}

class Node{ // 这个class应该放在哪里？ 一般来说在package里？这里只能放在文件最后？ 
// 一般意义上一个main函数下有多个class应该怎么安排
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(int key, int val){
    this.key = key;
    this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */