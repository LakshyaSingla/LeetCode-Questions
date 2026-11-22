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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] num = new int[1];
        num[0] = Integer.MIN_VALUE;
        path(root, num);
        return num[0];
    }

    int path(TreeNode root, int[] num){
        if(root == null) return 0;

        int left = Math.max(0, path(root.left, num));
        int right = Math.max(0, path(root.right, num));


        num[0] = Math.max(num[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}