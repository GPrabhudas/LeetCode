/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
Use Two pointer approach
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 1. empty list or list with only one node, no cycle
        if(head == null || head.next == null) {
            return null;
        }
        
        // 2. find the meeting point. This will be LOOP_SIZE - k steps into the list.
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // 3. collision found
            if(slow == fast) {
                break;
            }
        }
        
        // 3. error check, no meeting point, and therefore no loop
        if(fast == null || fast.next == null) {
            return null;
        }
        
        // 4. find the start of the loop
        // move slow to head and keep fast at meeting point. They both are k steps away from the loop start.
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // 5. both are pointing to the start of the loop.
        return slow;
    }
}