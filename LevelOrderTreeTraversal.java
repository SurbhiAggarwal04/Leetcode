package LeetCode;

import java.util.ArrayList;
import java.util.List;




 
public class LevelOrderTreeTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
          if(root==null)return result;
        List<TreeNode> current=new ArrayList<TreeNode>();
        List<Integer> currentList=new ArrayList<>();
        current.add(root);
        current.add(null);
        while(!current.isEmpty())
        {
            TreeNode n=current.remove(0);
            if(n==null)
            {
                result.add(currentList);
                if(!current.isEmpty())
                {
                    current.add(null);
                    currentList=new ArrayList<>();
                }
            }
            else
            {
                if(n.left!=null)current.add(n.left);
                if(n.right!=null)current.add(n.right);
                currentList.add(n.val);
            }
        }
        return result;
        
    }
}