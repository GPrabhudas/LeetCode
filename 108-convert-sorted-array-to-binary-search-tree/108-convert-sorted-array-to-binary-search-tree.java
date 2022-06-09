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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildBST(int[] nums, int l, int r) {
        // invalid range
        if(l > r) return null;
        
        // if leaf node, i.e l == r
        if( l == r ) return new TreeNode(nums[l]);
        
        // get mid value of the current segement make it root
        int mid = (l + r) >> 1;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        // build left subtree 
        root.left = buildBST(nums, l, mid - 1);
        
        // build right subtree
        root.right = buildBST(nums, mid + 1, r);
        
        // return node to parent calls
        return root;
    }
}