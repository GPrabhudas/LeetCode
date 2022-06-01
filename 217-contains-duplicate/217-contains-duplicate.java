class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> m = new HashMap<>();
        for(int num : nums) {
            if(m.containsKey(num)) return true;
            m.put(num, true);
        }
        return false;
    }
}