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
    List<List<Integer>> result = new ArrayList<>();
    void fun(TreeNode root,int sum,List<Integer> diary,int target){
        if(root==null){
            return;
        }

        sum = sum + root.val;
        diary.add(root.val);

        if(root.left == null && root.right == null){
            if(sum==target){
                result.add(new ArrayList<>(diary));
            }
        }
        fun(root.left,sum,diary,target);
        fun(root.right,sum,diary,target);
        diary.remove(diary.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> diary = new ArrayList<>();
        fun(root,0,diary,targetSum);
        return result;
    }
}