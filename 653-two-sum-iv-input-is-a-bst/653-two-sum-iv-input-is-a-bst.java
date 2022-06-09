/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int i = 0;
        int j = nums.size() - 1;
        
        while( i < j) {
            int sum = nums.get(i) + nums.get(j);
            
            if(sum == k) return true;
            
            if(sum < k) i++;
            
            if(sum > k) j--;
        }
        return false;
    }
    
    private void inorder(TreeNode root, List<Integer> nums) {
        if(root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}