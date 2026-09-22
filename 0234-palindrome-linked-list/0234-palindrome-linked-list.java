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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast= fast.next.next;
        }
        ListNode first = head;
        ListNode newHead = reverseLL(slow.next);
        ListNode second = newHead;
    
        while(second != null){
            if(first.val != second.val){
                reverseLL(newHead);
                return false;
            }else{
                first = first.next;
                second = second.next;
            }
        }
        reverseLL(newHead);
        return true;
    }
}