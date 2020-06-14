package Comp_P.Dynamic_Programming;
import java.util.Scanner;

class handler1
{
    int m,n;
    int counter=0;
    int storage[][];
    void input(int m,int n)
    {
        this.m=m;
        this.n=n;
        storage=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                storage[i][j]=-1;
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
    int  paths(int i,int j)
    {

        if(i==m-1&&j==n-1)
        {
            storage[i][j]=1;
            return 1;
        }
        if(isvalid(i,j)) {

            if(storage[i][j]!=-1) {
                counter++;
                return storage[i][j];
            }
            storage[i][j]=paths(i,j+1)+paths(i+1,j);
           return storage[i][j];
        }

            return 0;

    }
}
public class unique_paths {
    public static void main(String[] args) {
        handler1 handle=new handler1();
        int m,n;
        System.out.println("Enter number of row");
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        System.out.println("Enter number of columns");
        n=scanner.nextInt();
        handle.input(m,n);
        System.out.println("The total paths are "+handle.paths(0,0));
        System.out.println("Total call escaped "+handle.counter);

    }
}
