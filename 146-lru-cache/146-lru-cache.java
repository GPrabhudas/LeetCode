class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode prev;
    
    ListNode() {}

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    
    int capacity, length;
    ListNode dummy, tail;
    Map<Integer, ListNode> map;
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.dummy = new ListNode();
        this.tail = dummy;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        // cache is empty
        if(isEmpty()) return -1;
        
        // key is not present in cache
        if(!map.containsKey(key)) return -1;
        
        // key is present, return its value and move it to end of the list to keep least recently accessed keys at the end
        ListNode node = map.get(key);
        
        // if node is in middle of the list, remove it and move to end
        if(removeFromMiddle(node)) {
            addAtEnd(node);
        }
        return node.value;
    }
    
    
    public void put(int key, int value) {
        // key is already present in cache, update value and move it to end of the list
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            if(removeFromMiddle(node)) {
                addAtEnd(node);
            }
            node.value = value;
            map.put(key, node);
            return;
        }
        
        // key is not present in cache
        // if cache is full, remove least recently used key
        if(isFull()) {
            int k = removeFromBeginning();
            map.remove(k);
            length--;
        }
        
        ListNode node = new ListNode(key, value);
        addAtEnd(node);
        map.put(key, node);
        length++;
    }
    
    private int removeFromBeginning() {
        ListNode node = dummy.next;
        
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        
        // reset tail if node is last node of the list
        if(node.next == null) {
            tail = node.prev;
        }
        
        // detach node from list
        node.next = null;
        node.prev = null;
        
        return node.key;
    }
    
    private void addAtEnd(ListNode node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
    }
    
    private boolean removeFromMiddle(ListNode node) {
        // already at the end of the list, nothing to do
        if(node.next == null) return false;
        
        node.next.prev = node.prev;
        node.prev.next = node.next;
        
        // detach node from the list
        node.prev = null;
        node.next = null;
        
        return true;
    }
    
    
    private boolean isFull() {
        return this.capacity == this.length;
    }
    
    private boolean isEmpty() {
        return this.length == 0;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */