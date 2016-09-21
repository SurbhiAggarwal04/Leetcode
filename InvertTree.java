package LeetCode;


// Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
    
        if(root==null || (root.left==null && root.right==null))return root;
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=root.right;
        root.right=left;
        return root;
    }
}