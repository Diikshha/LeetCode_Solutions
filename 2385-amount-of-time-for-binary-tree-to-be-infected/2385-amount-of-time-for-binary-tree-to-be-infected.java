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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode startNode=null;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val==start){
                startNode=curr;
            }
            if(curr.left!=null){
                parentMap.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                parentMap.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        q.clear();
        Set<TreeNode> visited = new HashSet<>();
        q.add(startNode);
        visited.add(startNode);
        int minutes=-1;
        while(!q.isEmpty()){
            int size=q.size();
            minutes++;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    q.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    q.add(curr.right);
                }
                TreeNode parent = parentMap.get(curr);
                if(parent!=null && !visited.contains(parent)){
                    visited.add(parent);
                    q.add(parent);
                }
            }
        }
        return minutes;
    }
}