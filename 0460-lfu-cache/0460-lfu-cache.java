class Node{
    int key, value, count;
    Node next, prev;
    Node(){
        key = value = count = 0;
        next = prev = null;
    }
    Node(int key, int value){
        this.key = key;
        this.value = value;
        next = prev = null;
        count = 1;
    }
}

class DoublyLL{
    Node head, tail;
    int size;

    DoublyLL(){
        head = new Node();
        tail = new Node();
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    void addFront(Node node){
        Node front = head.next;
        head.next = node;
        node.prev = node;
        node.next= front;
        front.prev = node;
        size++;
    }
    void deleteNode(Node node){
        Node front = node.next;
        Node back = node.prev;
        front.prev = back;
        back.next = front;
        size--;
    }
}

class LFUCache {
    Map<Integer, Node> keyNode;
    Map<Integer, DoublyLL> freqList;
    int capacity;
    int minfreq;
    int currsize;
    public LFUCache(int capacity) {
        keyNode = new HashMap<>();
        freqList = new HashMap<>();
        this.capacity = capacity;
        minfreq = currsize = 0;
    }
    void updateFreq(Node node){
        keyNode.remove(node.key);
        freqList.get(node.count).deleteNode(node);

        if(node.count == minfreq && freqList.get(minfreq).size == 0){
            minfreq++;
        }
        node.count += 1;
        DoublyLL nextfreq = new DoublyLL();
        if(freqList.containsKey(node.count)){
            nextfreq = freqList.get(node.count);
        }
        nextfreq.addFront(node);
        keyNode.put(node.key, node);
        freqList.put(node.count, nextfreq);
    }
    public int get(int key) {
        if(!keyNode.containsKey(key)) return -1;
        
        Node node = keyNode.get(key);
        int val = node.value;
        updateFreq(node);
        return val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }
        if(currsize == capacity){
            DoublyLL min = freqList.get(minfreq);
            keyNode.remove(min.tail.prev.key);
            freqList.get(minfreq).deleteNode(min.tail.prev);
            currsize--;
        }
        currsize++;
        minfreq = 1;

        DoublyLL ls = new DoublyLL();
        if(freqList.containsKey(minfreq)){
            ls = freqList.get(minfreq);
        }
        Node newNode = new Node(key, value);
        ls.addFront(newNode);
        keyNode.put(key, newNode);
        freqList.put(minfreq, ls);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */