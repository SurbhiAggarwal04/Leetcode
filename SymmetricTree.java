package LeetCode;

// Definition for a binary tree node.
 
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return find(root.left,root.right);
    }
    public static boolean find(TreeNode n1,TreeNode n2)
    {
        if(n1==null && n2==null)return true;
        if(n1==null || n2==null)return false;
        boolean result=find(n1.left,n2.right) && find(n1.right,n2.left);
        if((n1!=null && n2!=null) && (n1.val==n2.val) && result )return true;
        return false;
        
        
    }
}