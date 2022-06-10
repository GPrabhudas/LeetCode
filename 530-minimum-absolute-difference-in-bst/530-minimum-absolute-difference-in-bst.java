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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        if(nodes.size() == 2) return Math.abs(nodes.get(0) - nodes.get(1));
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < nodes.size() - 1; i++) {
            int currMin = Math.min(Math.abs(nodes.get(i -1) -nodes.get(i)), Math.abs(nodes.get(i) - nodes.get(i + 1)));
            min = Math.min(min, currMin);
        }
        
        return min;
    }
    
    private void inorder(TreeNode root, List<Integer> nodes ) {
        if(root == null) return;
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }
}