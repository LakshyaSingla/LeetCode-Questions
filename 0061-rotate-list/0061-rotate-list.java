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
    public ListNode rotateRight(ListNode head, int k) {
        int len = 1;
        ListNode temp = head;
        while(temp != null && temp.next != null){
            temp = temp.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        temp.next = head;
        ListNode temp2 = head;
        int count = 1;
        while(temp2 != null){
            if(count == len - k) break;
            count++;
            temp2 = temp2.next;
        }
        ListNode newHead = temp2.next;
        temp2.next = null;
        return newHead;
    }
}