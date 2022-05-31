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
    TreeNode curr;
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode();
        curr = res;
        inorder(root);
        return res.right;
    }
    
    private void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            root.left = null;
            curr.right = root;
            curr = root;
            inorder(root.right);
        }
    }
}