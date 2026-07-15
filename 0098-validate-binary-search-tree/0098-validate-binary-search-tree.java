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
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         inorder(root,list);

//         for(int i = 1;i<list.size();i++){
//             if(list.get(i)<=list.get(i-1)){
//                 return false;
//             }
//         }

//         return true;
//     }
//     void inorder(TreeNode root,List<Integer> list){
//         if(root==null){
//             return;
//         }

//         inorder(root.left,list);
//         list.add(root.val);
//         inorder(root.right,list);

//     }
// }

class Solution {
    TreeNode prev = null;
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return ans;
    }
    void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);
        
        if(prev==null){
            prev=root;
        }else{
            if(root.val<=prev.val){
                ans = false;
                
            }
            prev = root;
        }

        inorder(root.right);

    }
}