package Comp_P.Dynamic_Programming;

  class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1() {}
     TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
         this.right = right;
     }
 }

class Solution1 {
    int pre=-1,next=-1;
    public int rob(TreeNode1 root) {
        int result[]=maxprofit(root);
        return Math.max(result[0],result[1]);
    }
    int [] maxprofit(TreeNode1 root)
    {
        if(root==null)
        {
            return new int[]{0,0};
        }
        int left[]= maxprofit(root.left);
        int right[]= maxprofit(root.right);
        int result[]=new int[2];
        result[0]=root.val+left[1]+right[1];
        result[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);


        return result;
    }
}