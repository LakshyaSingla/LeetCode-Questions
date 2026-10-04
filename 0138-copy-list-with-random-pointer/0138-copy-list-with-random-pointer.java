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
    Node insertele(Node head){
        Node temp = head;
        while(temp != null){
            Node nextNode = temp.next;
            temp.next =  new Node(temp.val);
            temp.next.next = nextNode;
            temp = nextNode;
        }
        return head;
    }
    Node insertRandom(Node head){
        Node temp = head;
        while(temp != null){
            Node copyNode = temp.next;
            copyNode.random = (temp.random != null) ? temp.random.next : null;
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
        insertele(head);
        insertRandom(head);
        return copyLL(head);
    }
}