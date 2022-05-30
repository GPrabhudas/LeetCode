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
/*
Use two pointer approach
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. list is empty, nothing to do
        if(head == null) return head;
        
        // 2. create a dummy node and point it to head, it will be easier to handle cases involving head node
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        // 3. move fast pointer n steps ahead to keep distance between fast and slow is n
        int i = 0;
        ListNode fast = dummy;
        while(i <= n) {
            fast = fast.next;
            i++;
        }
        
        // 4. move slow and fast pointer together
        // after the loop ends, slow points to the node one before the node to be deleted
        ListNode slow = dummy;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // 5. delete node
        slow.next = slow.next.next;
        return dummy.next;
    }
}