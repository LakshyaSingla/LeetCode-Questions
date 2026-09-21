/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode reverseLL(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode front = curr.next;
            curr.next = prev;
            prev=  curr;
            curr = front;
        }
        return prev;
    }
    ListNode findKthNode(ListNode temp, int k){
        int count = 1;
        while(temp != null && count < k ){
            count++;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }
                ListNode nextNode = kthNode.next;
                kthNode.next = null;
                reverseLL(temp);
                if(temp == head){
                    head = kthNode;
                    
                }else{
                    prevNode.next = kthNode; 
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}