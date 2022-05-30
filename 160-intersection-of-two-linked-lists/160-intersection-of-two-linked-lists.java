/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. pointer to hold larger annd greater list
        ListNode smaller, greater;
        
        // 2. get length of each list
        int headALength = getLength(headA);
        int headBLength = getLength(headB);
        
        // 3. get difference of length
        int gap = 0;
        if(headALength < headBLength) {
            smaller = headA;
            greater = headB;
            gap = headBLength - headALength;
        } else {
            smaller = headB;
            greater = headA;
            gap = headALength - headBLength;
        }
        
        // 4. advance greater list head by gap number of nodes
        while(gap > 0) {
            gap--;
            greater = greater.next;
        }
        
        // 5. now traverse both lists simulataneously
        while(smaller != null && greater != null) {
            // 6. intersection found
            if(smaller == greater) return smaller;
            smaller = smaller.next;
            greater = greater.next;
        }
        // 7. no intersection point
        return null;
    }
    
    private int getLength(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    
}