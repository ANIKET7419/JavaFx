package Comp_P;

import java.util.Scanner;

public class Matrix_maxarea {
int data[][];
    public void input(int data[][])
    {
        this.data=data;


    }
    public void Maximum_rectangle()
    {




    }
}
class Matrix
{
static  public void main(String argc[])
{
    Matrix_maxarea object=new Matrix_maxarea();
    int m,n;
    System.out.println("Enter Number of Rows");
    Scanner scanner=new Scanner(System.in);
    m=scanner.nextInt();
    System.out.println("Enter Number of Columns");
    n=scanner.nextInt();
    int data[][]=new int[m][n];
    System.out.println("Enter Data");
    for (int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            data[i][j]=scanner.nextInt();
        }
    }
    object.input(data);
    object.Maximum_rectangle();

}
}
