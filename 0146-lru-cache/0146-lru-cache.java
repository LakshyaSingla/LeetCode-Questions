class Node{
    int key, value;
    Node next, prev;
    Node(){
        key = value = 0;
        next = prev = null;
    }
    Node(int key, int value){
        this.key = key;
        this.value = value;
        next = prev= null;
    }
}
class LRUCache {
    Map<Integer, Node> keyNode;
    Node head, tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyNode = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    void addFront(Node node){
        Node front = head.next;
        head.next = node;
        node.prev = head;
        node.next = front;
        front.prev = node;
    }
    void deleteNode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
    
    public int get(int key) {
        if(!keyNode.containsKey(key)) return -1;

        Node node = keyNode.get(key);
        int val = node.value;
        deleteNode(node);
        addFront(node);
        return val;
    }
    
    public void put(int key, int value) {
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            node.value = value;
            deleteNode(node);
            addFront(node);
            return;
        }
        if(keyNode.size() == capacity){
            Node node = tail.prev;
            keyNode.remove(node.key);
            deleteNode(node);
        }
        Node newNode = new Node(key, value);
        addFront(newNode);
        keyNode.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */