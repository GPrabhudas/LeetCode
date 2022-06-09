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
    // do level order traversal
    // stop when you find the first leaf node
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int numOfNodes = q.size();
            depth++;
            boolean leafFound = false;
            
            while(numOfNodes > 0) {
                TreeNode curr = q.poll();
                // found leaf node.
                leafFound = curr.left == null && curr.right == null;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                if(leafFound) break;
                numOfNodes--;
            }
            
            if(leafFound) break;
        }
        
        return depth;
    }
}