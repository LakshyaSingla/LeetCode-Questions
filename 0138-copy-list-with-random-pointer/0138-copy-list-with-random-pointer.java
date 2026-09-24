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
    Node insertCopyNode(Node head){
        Node temp = head;

        while(temp != null){
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        return head;
    }
    Node connectRandomPointer(Node head){
        Node temp = head;
        while(temp != null){
            Node copy = temp.next;

            if(temp.random != null) copy.random = temp.random.next;
            else copy.random = null;
            temp = temp.next.next;
        }
        return head;
    }
    Node CopyLL(Node head){
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
        if(head == null )return null;
        insertCopyNode(head);
        connectRandomPointer(head);
        return CopyLL(head);
    }
}