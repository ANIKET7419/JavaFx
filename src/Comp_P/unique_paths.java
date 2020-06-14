package Comp_P;

import java.util.Scanner;

class handler
{
    int m,n;
    int counter=0;
    int backtracking[][];
    void input(int m,int n)
    {
       this.m=m;
       this.n=n;
       backtracking=new int[m][n];
       for (int i=0;i<m;i++)
       {
           for (int j=0;j<n;j++)
           {
               backtracking[i][j]=0;
           }
       }
    }
    boolean isvalid(int i,int j)
    {
        if(i<m&&j<n&&i>=0&&j>=0)
        {
            return true;
        }
        else
            return false;
    }
    void paths(int i,int j)
    {
        if(i==m-1&&j==n-1)
        {
            backtracking[i][j]=1;
            for (int i1=0;i1<m;i1++)
            {
                for(int j1=0;j1<n;j1++)
                {
                    System.out.print(backtracking[i1][j1]+" ");
                }
                System.out.println();
            }
            System.out.println();
            counter++;
            return;
        }
        if(isvalid(i,j)) {
            backtracking[i][j]=1;
            paths(i, j + 1);
            paths(i + 1, j);
            backtracking[i][j]=0;
        }

    }
}
public class unique_paths {
    public static void main(String[] args) {
    handler handle=new handler();
    int m,n;
    System.out.println("Enter number of row");
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        System.out.println("Enter number of columns");
        n=scanner.nextInt();
        handle.input(m,n);
        handle.paths(0,0);
        System.out.println("The total paths are "+handle.counter);

    }
}
