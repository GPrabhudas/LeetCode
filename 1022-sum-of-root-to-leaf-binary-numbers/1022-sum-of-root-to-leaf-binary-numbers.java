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
    int totalSum = 0;
    public int sumRootToLeaf(TreeNode root) {
        sumRoot(root, 0, 0);
        return totalSum;
    }
    
    private void sumRoot(TreeNode root, int level, int pathNumber) {
        if(root == null) return;
        
        // left shift number by 1 and add current node val
        pathNumber = pathNumber << 1 | root.val;
        
        // leaf node, end recursive call here
        if(root.left == null && root.right == null) {
            totalSum += pathNumber;
            return;
        }
        
        // go to left path
        sumRoot(root.left, level+1, pathNumber);
        
        // go to right path
        sumRoot(root.right, level+1, pathNumber);
    }
}