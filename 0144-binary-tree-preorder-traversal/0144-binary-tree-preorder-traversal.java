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
    void backtrack(TreeNode root, List<Integer> ans){
        if(root == null) return;

        ans.add(root.val);
        backtrack(root.left, ans);
        backtrack(root.right, ans);
    } 
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        backtrack(root, ans);
        return ans;
    }
}