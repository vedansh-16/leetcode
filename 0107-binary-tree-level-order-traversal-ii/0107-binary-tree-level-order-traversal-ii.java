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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> bigList = new ArrayList<>();
        if (root == null) {
            return bigList;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int lvlSize = q.size();
            List<Integer> smallList = new ArrayList<>();
            while(lvlSize>0){
                TreeNode node = q.peek();
                q.poll();

                smallList.add(node.val);

                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }

                lvlSize--;
            }
            bigList.add(smallList);
            
        }
        Collections.reverse(bigList);
        return bigList;
    }
}