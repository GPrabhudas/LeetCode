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
    public TreeNode bstFromPreorder(int[] preorder) {
       return buildTree(preorder, 0 , preorder.length - 1); 
    }
    
    private TreeNode buildTree(int[] nums, int l, int r) {
        // 1. invalid range
        if(l > r) {
            return null;
        }
        
        // 2. build node for current range [l,r]
        TreeNode root = new TreeNode(nums[l]);
        
        // 2.1 No need to build left and right subtrees if it is a lead node
        if(l == r) {
            return root;
        }
        
        // 2.2 Not a leaf node, we may need to build left and right subtrees
        int rightTreeIndex = getRightSubTreeIndex(nums, l, r);
        
        System.out.println(l +", " + r + ", " + rightTreeIndex);
        
        // 2.3 left subtree is in the range [l+1, rightTreeIndex - 1]
        root.left = buildTree(nums, l+1, rightTreeIndex - 1);
        
        // 2.4 right subtree is in the range [rightTreeIndex, r]
        root.right = buildTree(nums, rightTreeIndex, r);
        
        // 3. return current built node to parent
        return root;
    }
    
    private int getRightSubTreeIndex(int []nums, int l, int r) {
        int index = l + 1;
        while(index <= r && nums[l] > nums[index]) index++;
        return index;
    }
    
}