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
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;
    
    public int minDiffInBST(TreeNode root) {
        /*Minimum difference will be always from two nearest elements. We can use inorder traversal two find two nearest elements.*/ 
        // dummy node to store previous node
        inorder(root);
        return ans;
    }
    
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null) ans = Math.min(ans, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }
}