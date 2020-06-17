package Comp_P.Dynamic_Programming.Tree;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
/* It is not correct way*/
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
        boolean checker=true;
        for(int i=0;i<values.length;i++)
        if(isexplored[i]!=true)
            checker=false;

            if(checker)
            {
                System.out.println(result);
                return;
            }

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
               if(flag)
               {
                   boolean l=false;
                   for(int i=0;i<values.length;i++)
                   {
                       if(!isexplored[i])
                       {
                           if(values[i]<parent)
                           {
                               l=true;
                               String temp = result;
                               result = result.substring(0,result.length()-9)+values[i]+"nullnullnull";
                               isexplored[i] = true;
                               backtracking(depth + 1, true, values[i]);
                               backtracking(depth + 1, false, values[i]);
                               result = temp;
                               isexplored[i] = false;
                           }
                       }
                   }
               }
               else
               {

                   boolean l=false;
                   for(int i=0;i<values.length;i++) {
                       if (!isexplored[i]) {
                           if (values[i] >= parent) {
                               l = true;
                               String temp = result;
                               result = result.substring(0,result.length()-5)+values[i]+"nullnull";
                               isexplored[i] = true;
                               backtracking(depth + 1, true, values[i]);
                               backtracking(depth + 1, false, values[i]);
                               result = temp;
                               isexplored[i] = false;
                           }
                       }
                   }

               }
            }
    }

}
public class BSTMAIN {
    public static void main(String[] args) {
        BST object=new BST();
        System.out.println("Enter Size");
        Scanner scanner=new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        int values[]=new int[n];
        System.out.println("Enter Values");
        for (int i=0;i<n;i++)
        {
            values[i]=scanner.nextInt();
        }
        object.input(values);
        object.backtracking(0,true,-1);
    }
}
