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
    public TreeNode constructMaximumBinaryTree(int[] nums) {   
        // 2. build tree using nums
        return buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int []nums, int l, int r) {
        // 1. invalid subarray, means part of the array is done processing
        if(l > r) {
           return null;
        }
        
        
        // 2. max index for current sub-array [l, r]
        int maxIndex = getMaxIndex(nums, l, r);
        
        // 3. build node for current max
        TreeNode root = new TreeNode(nums[maxIndex]);
        
        // 4. build left subtree using left subarray
        root.left = buildTree(nums, l, maxIndex - 1);
        
        // 5. build right subtree using right subarray
        root.right = buildTree(nums, maxIndex + 1, r);
        
        // 6. return current node back to parent
        return root;
        
    }
    
    private int getMaxIndex(int []nums, int l, int r) {
        int maxIndex = l;
        for(int i = l + 1; i <= r; i++) {
            if(nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
}