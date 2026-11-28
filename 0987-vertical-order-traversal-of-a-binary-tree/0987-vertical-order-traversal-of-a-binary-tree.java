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
 class Trio{
    TreeNode node;
    int x; 
    int y;
    Trio(TreeNode node, int x, int y){
        this.node = node;
        this.x = x;
        this.y = y;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mpp = new TreeMap<>();

        Queue<Trio> q = new LinkedList<>();
        q.offer(new Trio(root, 0, 0));
        while(!q.isEmpty()){
            Trio trio = q.poll();
            TreeNode node = trio.node;
            int x = trio.x;
            int y = trio.y;

            if(!mpp.containsKey(x)){
                mpp.put(x, new TreeMap<>());
            }
            if(!mpp.get(x).containsKey(y)){
                mpp.get(x).put(y, new PriorityQueue<>());
            }
            mpp.get(x).get(y).offer(node.val);

            if(node.left != null) q.offer(new Trio(node.left, x - 1, y + 1));
            if(node.right != null) q.offer(new Trio(node.right, x + 1, y + 1));
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> yMap : mpp.values()){
            List<Integer> column = new ArrayList<>();

            for(PriorityQueue<Integer> pq : yMap.values()){
                while(!pq.isEmpty()){
                    column.add(pq.poll());
                }
            }
            ans.add(column);
        }
        return ans;
    }
}