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
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    ListNode findkthnode(ListNode head, int k){
        int count = 1;
        ListNode temp = head;
        while(temp != null){
            if(count == k) break;
            temp = temp.next;
            count++;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode KthNode = findkthnode(temp, k);
            if(KthNode == null){
                if(prevNode != null) prevNode.next = temp;
                break;
            }
            ListNode nextNode = KthNode.next;
            KthNode.next = null;
            reverseLL(temp);
            if(temp == head){
                head = KthNode;
                
            }else{
                prevNode.next = KthNode;
            }
            prevNode = temp;
                temp= nextNode;
        }
        return head;
    }
}