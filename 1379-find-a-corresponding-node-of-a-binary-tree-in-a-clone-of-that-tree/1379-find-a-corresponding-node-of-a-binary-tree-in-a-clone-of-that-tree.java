/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return findNode(cloned, target.val);
    }
    
    // use DFS (preorder) to find the node
    private TreeNode findNode(TreeNode root, int target) {
        if(root == null) return null;
        if(root.val == target) return root;
        
        TreeNode left = findNode(root.left, target);
        TreeNode right = findNode(root.right, target);
        
        return left == null ? right : left;
    }
}