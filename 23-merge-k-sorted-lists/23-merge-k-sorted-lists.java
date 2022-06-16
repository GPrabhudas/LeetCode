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

class CustomListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode a, ListNode b) {
        // sort by ascending values of nodes
        return a.val - b.val;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. nothing to do if lists are empty
        if(lists.length == 0) return null;
        
        // 2. if only one list
        if(lists.length == 1) return lists[0];
        
        // 3. Use MinHeap and merge all lists into single list
        ListNode res = new ListNode();
        ListNode tail = res;
        Queue<ListNode> heap = new PriorityQueue<>(new CustomListNodeComparator());
        
        // 3.1 add head of all lists to the priority queue
        for(ListNode head : lists) {
            // add to heap only if list is not empty
            if(head != null) {
                heap.add(head);   
            }
        }
        
        // 3.2 untill heap becomes empty, remvove min and add to result
        while(heap.size() > 0) {
            ListNode curr = heap.remove();
            
            // 3.3 store next of current node, we will have to add this to heap
            ListNode next = curr.next;
            
            // 3.4 detach curr node from rest of the list
            curr.next = null;
            
            // 3.5 add current node to result of merged list
            tail.next = curr;
            tail = tail.next;
            
            // 3.6 if current list is not empty, add next node to heap
            if(next != null) heap.add(next);
        }
        
        // return resultant merged linked list
        return res.next;
    }
}