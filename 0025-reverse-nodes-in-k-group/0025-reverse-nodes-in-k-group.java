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
            prev = curr;
            curr = front;
        }
        return prev;
    }
    ListNode findKthNode(ListNode head, int k){
        int count = 1;
        ListNode temp = head;
        while(temp != null && count != k){
            count++;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode KthNode = findKthNode(temp, k);
            if(KthNode != null){
                ListNode nextNode = KthNode.next;
                KthNode.next = null; 
                reverseLL(temp);
                if(temp == head){
                    head = KthNode;
                }else{
                    prevNode.next = KthNode;
                }
                prevNode = temp;
                temp = nextNode;
            }else{
                if(prevNode != null) prevNode.next = temp;
                break;
            }
        }
        return head;
    }
}