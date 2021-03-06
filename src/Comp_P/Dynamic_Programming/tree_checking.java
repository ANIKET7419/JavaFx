package Comp_P.Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      @Override
      public String toString()
      {

          return " "+ this.val;
      }
  }
class Solution {

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }

        return helper(1, n);
    }

    public List<TreeNode> helper(int m, int n){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(m>n){
            result.add(null);
            return result;
        }

        for(int i=m; i<=n; i++){
            List<TreeNode> ls = helper(m, i-1);
            List<TreeNode> rs = helper(i+1, n);

            for(TreeNode l: ls){
                for(TreeNode r: rs){
                    TreeNode curr = new TreeNode(i);
                    curr.left=l;
                    curr.right=r;
                    if(curr.left==null&&curr.right==null) {
                        System.out.println(curr.val + " "+curr.left + " " + curr.right);
                    }
                    else if(curr.left!=null&&curr.right==null)
                    {
                        System.out.println(curr.val+" "+curr.left.val+" "+curr.right);
                    }
                    else if(curr.left==null&&curr.right!=null)
                    {
                        System.out.println(curr.val+" "+curr.left+" "+curr.right.val);

                    }
                    else {
                        System.out.println(curr.val+" "+curr.left.val+" "+curr.right.val);
                    }
                    result.add(curr);
                }
            }
        }

        return result;
    }
}
public class tree_checking {
    public static void main(String[] args) {
        Solution object=new Solution();
        System.out.println(object.generateTrees(3));
    }
}
