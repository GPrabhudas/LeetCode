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
    public ListNode reverseKGroup(ListNode head, int k) {
        int numOfNodes = getNumOfNodes(head);
        // 1. less than or equal to one node, 
        if(numOfNodes <= 1) return head;
        
        // 2. if k is >= numOfNodes, reverse whole list and return
        if(k >= numOfNodes) return reverse(head);
        
        // 3. num of groups of length k
        int t = numOfNodes / k;
        
        // 4. dummy node to connect with reveresed groups
        ListNode dummy = new ListNode();
        
        // 5. tail pointer which points to end node of the reversed groups so far
        ListNode tail = dummy;
        
        // 6. get each group of k and reverse
        // 6.1 start pointer of group
        ListNode groupHead = head; // start initially from head
        for(int g = 0; g < t; g++) {
            ListNode temp = groupHead;
            int j = 0;
            // 6.2 move to last node of current group
            while(j < (k -1)) {
                temp = temp.next;
                j++;
            }
            // 6.3 head of next group
            ListNode nextGroupHead = temp.next;
            
            // 6.4 detach current group from list
            temp.next = null;
            
            // 6.5 reverse current group and connect with result using tail pointer
            tail.next = reverse(groupHead);
            
            // 6.6 update tail to the current group head, because current group head will be at end
            tail = groupHead;
            
            // 6.7 next group head
            groupHead  = nextGroupHead;
        }
        
        // 7. connect remaining nodes if any, for example there will be atleast one group with less than k nodes
        tail.next = groupHead;
        
        // 8. return head pointer to the modifided list
        return dummy.next;
        
    }
    
    private int getNumOfNodes(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null) return head;
        ListNode prev = null;
        ListNode curr = head;
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