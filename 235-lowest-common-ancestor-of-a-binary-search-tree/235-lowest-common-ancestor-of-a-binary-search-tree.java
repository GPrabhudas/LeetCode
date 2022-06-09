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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return lca(root, p.val < q.val ? p : q, p.val > q.val ? p : q);
    }
    
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        // 1. given p and q exists in binary search tree and p != q, so we will never 
        // reach null node
        
        // 2. if current node value falls in range [p, q] -> this will be the 
        // lowest common ansector
        if(root.val >= p.val && root.val <= q.val) return root;
        
        // 3. go to left if q is less than current node
        if(q.val < root.val) return lca(root.left, p, q );
        
        // 4. go to right
        return lca(root.right, p, q );
    }
}