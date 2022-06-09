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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        treePaths(root, "", paths);
        return paths;
    }
    
    private void treePaths(TreeNode root, String path, List<String> paths) {
        // empty node
        if(root == null) return;
        
        // leaf node, end of current path
        if(root.left == null && root.right == null) {
            path = path.equals("") ? path + root.val : path + "->" + root.val;
            paths.add(path);
            return;
        }
        
        path = path.equals("") ? path + root.val : path + "->" + root.val;
        treePaths(root.left, path, paths);
        treePaths(root.right, path, paths);
    }
}