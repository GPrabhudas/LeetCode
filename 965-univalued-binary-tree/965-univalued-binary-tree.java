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
    // use preorder traversal to check if tree is univalued
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return (root.left != null ? root.val == root.left.val && isUnivalTree(root.left) : true)
            && (root.right != null ? root.val == root.right.val && isUnivalTree(root.right) : true);
    }
}