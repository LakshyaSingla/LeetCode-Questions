class Node{
    int key, value, count;
    Node next, prev;
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
        size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    void addFront(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        nextNode.prev = node;
        node.next = nextNode;
        size++;
    }
    void deleteNode(Node node){
        Node front = node.next;
        Node back = node.prev;
        back.next = front;
        front.prev = back;
        size--;
    }
}
class LFUCache {
    Map<Integer, DoublyLL> freqListMap;
    Map<Integer, Node> keyNode;
    int capacity;
    int minfreq;
    int currsize;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        minfreq = currsize = 0;
        freqListMap = new HashMap<>();
        keyNode = new HashMap<>();
    }
    void updateFreq(Node node){
        keyNode.remove(node.key);
        freqListMap.get(node.count).deleteNode(node);
        if(node.count == minfreq && freqListMap.get(minfreq).size == 0){
            minfreq += 1;
        }

        DoublyLL list = new DoublyLL();
        if(freqListMap.containsKey(node.count + 1)){
            list = freqListMap.get(node.count + 1);
        }
        node.count += 1;
        list.addFront(node);
        keyNode.put(node.key, node);
        freqListMap.put(node.count, list);
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
            DoublyLL list = freqListMap.get(minfreq);
            keyNode.remove(list.tail.prev.key);
            freqListMap.get(minfreq).deleteNode(list.tail.prev); 
            currsize--;
        }
        currsize++;
        minfreq = 1;
        DoublyLL minList = new DoublyLL();
        if(freqListMap.containsKey(minfreq)){
            minList = freqListMap.get(minfreq);
        }
        Node newNode = new Node(key, value);
        minList.addFront(newNode);
        keyNode.put(key, newNode);
        freqListMap.put(minfreq, minList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */