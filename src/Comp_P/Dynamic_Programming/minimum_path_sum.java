package Comp_P.Dynamic_Programming;
import java.util.Scanner;

class handler2
{
    int m,n;
    int counter=0;
    int storage[][];
    int data[][];
    void input(int m,int n,int data[][])
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
        this.data=data;
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
            storage[i][j]=data[i][j];
            return storage[i][j];
        }
        if(isvalid(i,j)) {

            if(storage[i][j]!=-1) {
                counter++;
                return storage[i][j];
            }
            int temp1=paths(i,j+1);
            int temp2=paths(i+1,j);
            if(temp1==-1&&temp2!=-1)
            {
                storage[i][j]=temp2+data[i][j];
            }
            else if(temp2==-1&&temp1!=-1)
            {
                storage[i][j]=temp1+data[i][j];
            }
            else if(temp2==-1&&temp1==-1)
            {
                storage[i][j]=data[i][j];
            }
            else
            {
                if(temp1+data[i][j]>temp2+data[i][j])
                {
                    storage[i][j]=temp2+data[i][j];
                }
                else
                {
                    storage[i][j]=temp1+data[i][j];
                }
            }
            return storage[i][j];
        }

        return -1;

    }
}
public class minimum_path_sum {
    public static void main(String[] args) {
        handler2 handle=new handler2();
        int m,n;
        System.out.println("Enter number of row");
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        System.out.println("Enter number of columns");
        n=scanner.nextInt();
        int data[][]=new int[m][n];
        System.out.println("Enter Data");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                data[i][j]=scanner.nextInt();
            }
        }
        handle.input(m,n,data);
        System.out.println("The Minimal Cost is  "+handle.paths(0,0));
        System.out.println("Total call escaped "+handle.counter);

    }
}

