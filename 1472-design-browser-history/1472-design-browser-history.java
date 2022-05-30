class ListNode {
    String url;
    ListNode next;
    ListNode prev;
    
    ListNode(String url) {
        this.url = url;
    }
}

class BrowserHistory {
    
    ListNode head, pos;
    
    public BrowserHistory(String homepage) {
        head = new ListNode(homepage);
        pos = head;
    }
    
    public void visit(String url) {
        ListNode temp = new ListNode(url);
        ListNode posNext = pos.next;
        
        pos.next = temp;
        temp.prev = pos;
        pos = temp;
        
        // clear forward history if needed
        if(posNext != null) {
            posNext.prev = null;
        }
        
    }
    
    public String back(int steps) {
        int i = 0;
        while(i < steps && pos.prev != null) {
            pos = pos.prev;
            i++;
        }
        return pos.url;
    }
    
    public String forward(int steps) {
        int i = 0;
        while(i < steps && pos.next != null) {
            pos = pos.next;
            i++;
        }
        return pos.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */