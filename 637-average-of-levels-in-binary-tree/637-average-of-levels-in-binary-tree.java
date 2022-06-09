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
    // use level order traversal
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Double> res = new ArrayList<>();
        
        while(!q.isEmpty()) {
            // number of nodes in current level
            int numOfNodes = q.size();
            int k = 0;
            double sum = 0;
            while(k < numOfNodes) {
                TreeNode curr =  q.poll();
                
                sum += curr.val;
                
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                
                if(curr.right != null) {
                    q.offer(curr.right);
                }
                k++;
            }
            
            res.add((sum / numOfNodes));
        }
        
        return res;
    }
}