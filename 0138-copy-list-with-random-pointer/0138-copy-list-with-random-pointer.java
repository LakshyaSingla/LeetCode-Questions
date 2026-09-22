/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Node insertNewNode(Node head){
        Node temp = head;
        while(temp != null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        return head;
    }
    Node randomPointer(Node head){
        Node temp = head;
        
        while(temp != null){
            Node copyNode = temp.next;
            if(temp.random != null){
                copyNode.random = temp.random.next;
            }else{
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
        return head;
    }
    Node copyLL(Node head){
        Node dummy = new Node(-1);
        Node curr = dummy;
        Node temp = head;
        while(temp != null){
            curr.next = temp.next;
            curr = curr.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        insertNewNode(head);
        randomPointer(head);
        return copyLL(head);
    }
}