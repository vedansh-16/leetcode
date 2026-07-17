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
    TreeNode prev = null;
    TreeNode g1first = null;
    TreeNode g1second = null;
    TreeNode g2first = null;
    TreeNode g2second = null;
    int galat= 0;
    void fun(TreeNode root){
        if(root==null){
            return;
        }

        fun(root.left);

        if(prev==null){
            prev = root;
        }else{
            if(root.val<prev.val){
                if(galat==0){
                    g1first = prev;
                    g1second = root;
                    galat++;
                }else{
                    g2first = prev;
                    g2second = root;
                    galat++;
                }
            }
            prev = root;
        }

        fun(root.right);
    }
    public void recoverTree(TreeNode root) {
        fun(root);
        if(galat==1){
            swap(g1first,g1second);
        }else{
            swap(g1first,g2second);
        }
    }

    void swap(TreeNode r1,TreeNode r2){
    
        int temp = r1.val;
        r1.val = r2.val;
        r2.val  = temp;
    }
}