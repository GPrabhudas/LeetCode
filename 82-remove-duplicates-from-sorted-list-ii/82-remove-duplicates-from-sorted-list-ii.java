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
    public ListNode deleteDuplicates(ListNode head) {
        // 1. empty list or list with only one node, nothing to do
        if(head == null || head.next == null) return head;
        
        // 2. dummy node to hold the result
        ListNode dummy = new ListNode();
        
        // 3. tail node to do insert operation in O(1)
        ListNode tail = dummy;
        
        // 4. temp node to traverse list
        ListNode temp = head;
        
        // 5. node to hold temporary next pointer
        ListNode next = null;
        
        // 6. traverse list and remove all duplicates
        while(temp != null) {
            // 7. If current node is duplicate, remove all of its occurrences
            ListNode ptr = temp;
            while(ptr != null && ptr.next != null && ptr.val == ptr.next.val) {
                ptr = ptr.next;
            }
            
            // 8. ptr and temp is same, means no duplicate value
            if(ptr == temp) {
                next = temp.next;
                temp.next = null;
                tail.next = temp;
                tail = temp;
                temp = next;
            } else {
                // 9. duplicates found, start processing from next node
                temp = ptr.next;
            }
        }
        
        return dummy.next;
    }
}