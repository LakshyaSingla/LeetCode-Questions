class Node{
    int key, value;
    Node prev, next;
    
    Node(){
        key = value = -1;
        prev = null;
        next = null;
    }
    Node(int key, int value){
        this.key = key;
        this.value = value;
        prev = next = null;
    }
}
class LRUCache {
    Map<Integer, Node> mpp;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        mpp = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    void insertAfterHead(Node node){
        Node currafterhead = head.next;
        head.next = node;
        node.prev = head;
        node.next = currafterhead;
        currafterhead.prev = node;
    }
    void deletenode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public int get(int key) {
        if(!mpp.containsKey(key)) return -1;

        Node node = mpp.get(key);
        deletenode(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(mpp.containsKey(key)){
            Node node = mpp.get(key);
            node.value = value;
            deletenode(node);
            insertAfterHead(node);
            return;
        }

        if(mpp.size() == capacity){
            Node node = tail.prev;
            mpp.remove(node.key);
            deletenode(node);
        }
        Node newNode = new Node(key, value);
        mpp.put(key, newNode);
        insertAfterHead(newNode);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */