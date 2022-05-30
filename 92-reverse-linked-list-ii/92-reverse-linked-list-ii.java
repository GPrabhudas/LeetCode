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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1. If list is empty or has only node, nothing to do
        if(head == null || head.next == null) return head;
        
        // 2. if left and right are same, nothing to do
        if(left == right) return head;
        
        // 3. add dummy node at the begining of list to handle case involving head
        ListNode dummy = new ListNode(0, head);
        
        // 4. get left and prev of left
        int i = 0;
        ListNode temp = dummy;
        while(i < (left - 1)) {
            temp = temp.next;
            i++;
        }
        
        ListNode leftNodePrev = temp;
        ListNode leftNode = temp.next;
        
        // 4. get the right and next of right
        while(i < right) {
            temp = temp.next;
            i++;
        }
        
        ListNode rightNode = temp;
        ListNode rightNodeNext = temp.next;
        
        // 5. detatch list [left, right] from the list
        leftNodePrev.next = null;
        rightNode.next = null;
        
        // 6. reverse list [left, right]
        ListNode revHead = reverse(leftNode);
        
        // 7. put back reversed list [left, right]
        leftNodePrev.next = revHead;
        leftNode.next = rightNodeNext;
        
        // 8. return modified list
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        if( head== null) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
}