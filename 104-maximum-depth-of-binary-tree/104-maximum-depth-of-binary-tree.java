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
    public int maxDepth(TreeNode root) {
        // no depth for node nodes
        if(root == null) return 0;
        
        // get depth of the left subtree
        int left = 1 + maxDepth(root.left);
        
        // get depth of the right subtree
        int right = 1 + maxDepth(root.right);
        
        // return max of two
        return Math.max(left, right);
    }
}