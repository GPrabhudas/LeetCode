class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        
        for(int num : nums2) {
            while(!s.empty() && s.peek() < num) {
                m.put(s.pop(), num);
            }
            s.push(num);
        }
        
        while(!s.empty()) {
            m.put(s.pop(), -1);
        }
        
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = m.get(nums1[i]);
        }
        
        return nums1;
    }
}