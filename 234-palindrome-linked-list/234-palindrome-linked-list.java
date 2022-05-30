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
    public boolean isPalindrome(ListNode head) {
        // 1. empty list or list with one node is always a palindrome
        if(head == null || head.next == null) return true;
        
        // 2. get length of list
        int length = getLength(head);
        
        // 3. get index of middle node
        int skipNodes = (length & 1) > 0 ? (length >> 1) + 1 : (length >> 1);
        
        // 4. starting node of the second half
        ListNode secondHalf = head;
        while(skipNodes > 0) {
            secondHalf = secondHalf.next;
            skipNodes--;
        }
        
        // 5. reverse second half
        ListNode temp2 = reverse(secondHalf);
        ListNode temp1 = head;
        
        // 6. traverse both halfs simultaneously
        while(temp1 != null && temp2 != null) {
            // 7. not a palindrome
            if(temp1.val != temp2.val) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return true;
    }
    
    private int getLength(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode next = head;
        
        while(temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}