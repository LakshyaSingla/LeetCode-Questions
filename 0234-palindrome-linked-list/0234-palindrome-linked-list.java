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
        ListNode prev=  null;
        while(curr != null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode newHead = reverseLL(slow.next);
        ListNode right = newHead;
        while(right != null){
            if(left.val != right.val){
                reverseLL(newHead);
                return false;
            }else{
                left = left.next;
                right = right.next;
            }
        }
        reverseLL(newHead);
        return true;
        
    }
}