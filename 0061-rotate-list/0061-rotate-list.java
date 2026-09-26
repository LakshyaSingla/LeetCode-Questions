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
        ListNode tail = head;
        int len = 1;
        while(tail != null && tail.next != null){
            len++;
            tail = tail.next;
        }
        k = (k % len);
        if(k == 0) return head;
        tail.next = head;
        ListNode temp = head;
        int count = 1;
        while(len - k != count){
            count++;
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}