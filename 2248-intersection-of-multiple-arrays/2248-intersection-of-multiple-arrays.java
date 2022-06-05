class Solution {
    public List<Integer> intersection(int[][] nums) {
        int numOfArrays = nums.length;
        
        int largestArray = 0;
        
        // create map for each array and use value as key
        List<Map<Integer, Boolean>> arrMap = new ArrayList<>();
        for(int i = 0; i< numOfArrays; i++) {
            // create map
            Map<Integer, Boolean> m = new HashMap<>();
            
            for(int num : nums[i]) {
                m.put(num, true);
            }
            
            // add map to list
            arrMap.add(m);
            
            if(nums[i].length > nums[largestArray].length) {
                largestArray = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        // check for intersection
        for(int num : nums[largestArray]) {
            
            // check if current element is intersection
            boolean isIntersection = true;
            for(Map<Integer, Boolean> m : arrMap) {
                if(!m.containsKey(num)) {
                    isIntersection = false;
                    break;
                }
            }
            
            if(isIntersection) {
                res.add(num);
            }
        }
        
        Collections.sort(res);
        return res;
    }
}