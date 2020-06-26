package Comp_P.Dynamic_Programming;

import java.util.Scanner;

/*

******Without Dp***********

class UniquePaths2Handler
{
    int data[][];
    int solution[][];
    void input(int data[][])
    {
        this.data=data;
        solution=new int[data.length][data[0].length];
    }

    boolean issafe(int i,int j)
    {
        if (data[i][j]==1||i<0||i>=data.length||j<0||j>=data[0].length)
            return false;
        else
            return true;
    }
    void uniquepaths(int i,int j)
    {

        if (i>=data.length||j>=data[0].length)
            return;
        if (i==data.length-1&&j==data[0].length-1)
        {
            solution[i][j]=1;
            for (int k=0;k<i+1;k++)
            {
                for (int m=0;m<j+1;m++)
                {
                    System.out.print(solution[k][m]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        if (issafe(i,j))
        {
            solution[i][j]=1;
            uniquepaths(i+1,j);
            uniquepaths(i,j+1);
            solution[i][j]=0;
        }

    }

}
public class UniquePaths2 {
    public static void main(String[] args) {
        UniquePaths2Handler handler=new UniquePaths2Handler();
        int m,n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Number of rows");
        m=scanner.nextInt();
        System.out.println("Enter Number of columns");
        n=scanner.nextInt();
        int data[][]=new int[m][n];
        System.out.println("Enter Data");
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                data[i][j]=scanner.nextInt();
            }
        }
        handler.input(data);
        handler.uniquepaths(0,0);
    }
}
*/
class UniquePaths2Handler
{
    int data[][];
    int solution[][];
    void input(int data[][])
    {
        this.data=data;
        solution=new int[data.length][data[0].length];
    }

    boolean issafe(int i,int j)
    {
        if (data[i][j]==1||i<0||i>=data.length||j<0||j>=data[0].length)
            return false;
        else
            return true;
    }
    void uniquepaths(int i,int j)
    {

        if (i>=data.length||j>=data[0].length)
            return;
        if (i==data.length-1&&j==data[0].length-1)
        {
            solution[i][j]=1;
            for (int k=0;k<i+1;k++)
            {
                for (int m=0;m<j+1;m++)
                {
                    System.out.print(solution[k][m]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        if (issafe(i,j))
        {
            solution[i][j]=1;
            uniquepaths(i+1,j);
            uniquepaths(i,j+1);
            solution[i][j]=0;
        }

    }

}
public class UniquePaths2 {
    public static void main(String[] args) {
        UniquePaths2Handler handler=new UniquePaths2Handler();
        int m,n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Number of rows");
        m=scanner.nextInt();
        System.out.println("Enter Number of columns");
        n=scanner.nextInt();
        int data[][]=new int[m][n];
        System.out.println("Enter Data");
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                data[i][j]=scanner.nextInt();
            }
        }
        handler.input(data);
        handler.uniquepaths(0,0);
    }
}