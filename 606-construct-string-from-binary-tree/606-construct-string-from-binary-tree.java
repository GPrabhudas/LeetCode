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
    StringBuilder sb = new StringBuilder();
    
    public String tree2str(TreeNode root) {
        str(root);
        return sb.toString();
    }
    
    private void str(TreeNode root) {
        if(root == null) return;
        
        sb.append(root.val);
        
        // process left subtree
        if(root.left != null || (root.left == null && root.right != null)) {
            sb.append('(');
            str(root.left);
            sb.append(')');
        }
        
        // process right subtree
        if(root.right != null) {
            sb.append('(');
            str(root.right);
            sb.append(')');
        }
        
    }
}