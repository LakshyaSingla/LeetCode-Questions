class Node{
    int key, value, count;
    Node next, prev;

    Node(){
        key = value = 0;
        next = prev= null;
    }
    Node(int key, int value){
        this.key = key;
        this.value = value;
        count = 1;
        next = prev = null;
    }
}
class DoublyList{
    Node head, tail;
    int size;
    DoublyList(){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    void addFront(Node node){
        Node front = head.next;
        head.next = node;
        node.prev = head;
        front.prev = node;
        node.next = front;
        size++;
    }
    void deleteNode(Node node){
        Node front = node.next;
        Node back =  node.prev;
        front.prev = back;
        back.next = front;
        size--;
    }
}
class LFUCache {
    int capacity;
    Map<Integer, Node> keyNode;
    Map<Integer, DoublyList> freqListMap;
    int minfreq, currsize;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
        minfreq = currsize = 0;
    }
    void updatefreqList(Node node){
        keyNode.remove(node.key);
        freqListMap.get(node.count).deleteNode(node);
        if(node.count == minfreq && freqListMap.get(node.count).size == 0){
            minfreq++;
        }
        DoublyList nextfreq = new DoublyList();
        if(freqListMap.containsKey(node.count + 1)){
            nextfreq = freqListMap.get(node.count + 1);
        }
        node.count += 1;
        nextfreq.addFront(node);
        keyNode.put(node.key, node);
        freqListMap.put(node.count, nextfreq);
    }
    public int get(int key) {
        if(!keyNode.containsKey(key)) return -1;

        Node node = keyNode.get(key);
        int val = node.value;
        updatefreqList(node);
        return val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            node.value = value;
            updatefreqList(node);
            return;
        }

        if(currsize == capacity){
            DoublyList list = freqListMap.get(minfreq);
            keyNode.remove(list.tail.prev.key);
            freqListMap.get(minfreq).deleteNode(list.tail.prev);
            currsize--;
        }
        currsize++;
        minfreq = 1;
        DoublyList minList = new DoublyList();
        if(freqListMap.containsKey(minfreq)){
            minList = freqListMap.get(minfreq);
        }
        Node newNode = new Node(key, value);
        minList.addFront(newNode);
        freqListMap.put(minfreq, minList);
        keyNode.put(key, newNode);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */