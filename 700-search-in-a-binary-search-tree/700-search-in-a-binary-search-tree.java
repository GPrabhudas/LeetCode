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
    public TreeNode searchBST(TreeNode root, int val) {
        // root is null
        if(root == null) return null;
        
        // node is found
        if(root.val == val) return root;
        
        // go to left if val is less than current node val
        if(val < root.val) return searchBST(root.left, val);
        
        // else search in right half
        return searchBST(root.right, val);
    }
}