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
    public ListNode mergeNodes(ListNode head) {
        // 1. dummy node to store result
        ListNode dummy = new ListNode();
        
        // 2. tail node to perform insert operations in O(1) time.
        ListNode tail = dummy;
        
        // 3. sum to be calculated between two consecutive 0's
        int sum = 0;
        // 4. traverse list from head and merge nodes between two consecutive 0's
        ListNode temp = head.next;
        while(temp != null) {
            // 5. store next
            ListNode next = temp.next;
            
            // 6. merge node 
            sum += temp.val;
            
            // 7. start of next consecutive 0's, so add current result of merged values to result
            if(temp.val == 0) {
                temp.val = sum;
                sum = 0;
                tail.next = temp;
                tail = temp;
            }
            
            // 8. detach node from rest of the list
            temp.next = null;
            
            // 9. start same process from next node
            temp = next;
        }
        
        return dummy.next;
    }
}