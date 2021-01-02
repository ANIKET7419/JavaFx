package Comp_P;

import java.util.Scanner;

public class WhereWillBallFall {


    public static int dfs(int row,int column,int box[][])
    {

        if (row>=box.length)
            return column;
        if (column>=box[0].length||column<0)
            return -1;
        if (box[row][column]==1)
        {
            if (column==box[0].length-1)
                return -1;
            if (box[row][column+1]==1)
            return dfs(row+1,column+1,box);
            else
                return -1;
        }
        else
        {
            if (column==0)
                return -1;
            if (box[row][column-1]==-1)
                return dfs(row+1,column-1,box);
            else
                return -1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the value of m");
        int m=scanner.nextInt();
        System.out.println("Enter the value of n");
        int n=scanner.nextInt();
        System.out.println("Enter the box data ( -1 or 1 ) ");
        int box[][]=new int[m][n];
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                box[i][j]=scanner.nextInt();
        int result[]=new int[n];
        for (int i=0;i<n;i++)
            result[i]=dfs(0,i,box);
        System.out.println("Result : ->  ");
        System.out.print("[ ");
        for (int i=0;i<n;i++)
            System.out.print(result[i]+" , ");
        System.out.println(" ]");

    }
}
