/*
Kadane's algorithm to find sub array with maximum sub
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        
        for(int num : nums) {
            max_ending_here += num;
            
            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            
            if(max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        
        return max_so_far;
    }
}