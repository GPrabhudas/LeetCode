class Solution {
    public List<Integer> intersection(int[][] nums) {
        // sort all individual arrays
        for(int[] arr : nums) {
            Arrays.sort(arr);
        }
        
        // find the intersections
        List<Integer> res = new ArrayList<>();
        
        int[] pointers = new int[nums.length];
        
        boolean completed = false;
        
        while(!isEmpty(pointers, nums)) {
            // check for intersection
            if(isIntersection(pointers, nums)) {
                res.add(nums[0][pointers[0]]);
                
                // increment pointers
                movePointers(pointers);
            } else {
                // move pointer with smallest value
                moveSmallestPointer(pointers, nums);
            }
        }
        
        return res;
    }
    
    private void movePointers(int []pointers) {
        for(int i = 0; i < pointers.length; i++) {
            pointers[i]++;
        }
    }
    
    private void moveSmallestPointer(int []pointers, int [][] nums) {
        int small = nums[0][pointers[0]];
        int smallIndex = 0;
        
        for(int i = 1; i < pointers.length; i++) {
            if(nums[i][pointers[i]] < small) {
                small = nums[i][pointers[i]];
                smallIndex = i;
            }
        }
        pointers[smallIndex]++;
    }
    
    private boolean isIntersection(int []pointers, int [][] nums) {
        // check current value is intersection
        int curr = nums[0][pointers[0]];
        
        for(int i = 1; i < pointers.length; i++) {
            if(nums[i][pointers[i]] != curr) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isEmpty(int[] pointers, int [][]nums) {
        // if any array returns end, then no need to find intersection further
        for(int i = 0; i < pointers.length; i++) {
            if(pointers[i] >= nums[i].length) {
                return true;
            }
        }
        
        return false;
    }
}