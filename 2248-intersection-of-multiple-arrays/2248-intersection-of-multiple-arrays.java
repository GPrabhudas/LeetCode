class Solution {
    public List<Integer> intersection(int[][] nums) {
        // use priority queue, build priority queue for each array
        List<PriorityQueue<Integer>> pqList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for(int num : nums[i]) {
                q.add(num);
            }
            pqList.add(q);
        }
        
        // Find intersection and build result
        List<Integer> res = new ArrayList<>();
        while(!anyPQEmpty(pqList)) {
            // check if top of pq is intersection
            int curr = pqList.get(0).peek();
            boolean isIntersection = true;
            for(int i = 1; i < pqList.size(); i++) {
                if(curr != pqList.get(i).peek()) {
                    // not intersection point
                    // find min pq and move its head
                    moveMinPQHead(pqList);
                    isIntersection = false;
                    break;
                }
            }
            
            if(isIntersection) {
                res.add(curr);
                moveAllHeads(pqList);
            }
        }
        return res;
    }
    
    private boolean anyPQEmpty(List<PriorityQueue<Integer>> pqList) {
       for(PriorityQueue<Integer> p : pqList) {
            if(p.isEmpty()) return true;
       }
       return false; 
    }
    
    private void moveAllHeads(List<PriorityQueue<Integer>> pqList) {
        for(PriorityQueue<Integer> p : pqList) {
            p.remove();
        }
    }
    
    private void moveMinPQHead(List<PriorityQueue<Integer>> pqList) {
        int minPQHead = 0;
        int minValue = pqList.get(0).peek();
        
        for(int i = 1; i < pqList.size(); i++) {
            if(pqList.get(i).peek() < minValue) {
                minValue = pqList.get(i).peek();
                minPQHead = i;
            }
        }
        
        pqList.get(minPQHead).remove();
    }
}