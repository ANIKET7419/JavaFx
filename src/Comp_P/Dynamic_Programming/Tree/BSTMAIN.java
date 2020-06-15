package Comp_P.Dynamic_Programming.Tree;

import org.jetbrains.annotations.NotNull;

class Tree
{
    Tree left,right,parent;
    int data;
}
class BST {
    int values[];
    boolean isexplored[];
    String result="";
    void input(@NotNull int values[])
    {
        this.values=values;
        isexplored=new boolean[values.length];
        for (int i=0;i<values.length;i++)
            isexplored[i]=false;
    }
    void backtracking(int depth,boolean flag,int parent)
    {




            if(depth==0)
            for (int i = 0; i < values.length;i++)
            {
                if(!isexplored[i]) {
                    String temp = result;
                    result += values[i];
                    isexplored[i] = true;
                    backtracking(depth + 1, true, values[i]);
                    backtracking(depth + 1, false, values[i]);
                    result = temp;
                    isexplored[i] = false;
                }
            }
            else{

            }
    }

}
public class BSTMAIN {
}
