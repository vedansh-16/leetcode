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

 //Approach-1(Inorder traversal + Two Pointers)
 //Inorder of BST is sorted
/*class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        fun(root,list);
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            int sum = list.get(left)+list.get(right);
            if(sum==k){
                return true;
            }else if(sum>k){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
    void fun(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        fun(node.left,list);
        list.add(node.val);
        fun(node.right,list);
    }
}*/
class Solution {
    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> desc = new Stack<>();

    TreeNode getSmall(){
        if(asc.isEmpty()){
            return null;
        }
        TreeNode small = asc.peek();
        asc.pop();

        TreeNode rightChild = small.right;
        while(rightChild!=null){
            asc.push(rightChild);
            rightChild = rightChild.left;
        }
        return small;
    }

    TreeNode getBig(){
        if(desc.isEmpty()){
            return null;
        }
        TreeNode big = desc.peek();
        desc.pop();

        TreeNode leftChild = big.left;
        while(leftChild!=null){
            desc.push(leftChild);
            leftChild = leftChild.right;
        }
        return big;
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }

        TreeNode t = root;
        while(t!=null){
            asc.push(t);
            t = t.left;
        }
        
        t=root;
        while(t!=null){
            desc.push(t);
            t = t.right;
        }

        TreeNode i = getSmall();
        TreeNode j = getBig();

        while((i!=null&&j!=null) && (i!=j) && (i.val<=j.val)){
            int sum = i.val + j.val;
            if(sum==k){
                return true;
            }else if(sum>k){
                j=getBig();
            }else{
                i=getSmall();
            }
        }
        return false;
    }
}