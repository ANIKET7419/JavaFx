package Comp_P.Dynamic_Programming;
/*
On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once( This part is not implemented).
 */
import java.util.Arrays;
import java.util.Scanner;

class UniquePaths3Handler
{
    int data[][];
    int storage[][];
    boolean traversed[][];
    int counter=0;
    void input(int data[][])
    {
        this.data=data;
        storage=new int[data.length][data[0].length];
        traversed=new boolean[data.length][data[0].length];
        for (int temp[]:storage)
        {
            Arrays.fill(temp,-1);
        }
        for (boolean temp[]:traversed)
        {
            Arrays.fill(temp,false);
        }

    }

    boolean issafe(int i,int j)
    {
        if (data[i][j]==-1||i<0||i>=data.length||j<0||j>=data[0].length||traversed[i][j])
            return false;
        else
            return true;
    }
    int  uniquepaths(int i,int j,int endx,int endy)
    {

        if (i>=data.length||j>=data[0].length||i<0||j<0)
            return -1;
        if (i==endx&&j==endy)
        {
            storage[i][j]=1;
            return 1;
        }
        if (storage[i][j]!=-1) {
            counter++;
            return storage[i][j];
        }
        int paths=0;
        if (issafe(i,j))
        {
            traversed[i][j]=true;
            int temp1=uniquepaths(i+1,j,endx,endy);
            int temp2=uniquepaths(i,j+1,endx,endy);
            int temp3=uniquepaths(i-1,j,endx,endy);
            int temp4=uniquepaths(i,j-1,endx,endy);
            if (temp1!=-1)
                paths+=temp1;
            if (temp2!=-1)
                paths+=temp2;
            if (temp3!=-1)
                paths+=temp3;
            if (temp4!=-1)
                paths+=temp4;

        }
        return storage[i][j]= paths;
    }

}
public class UniquePaths3 {
    public static void main(String[] args) {
        UniquePaths3Handler handler=new UniquePaths3Handler();
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
        int startX=-1,startY=-1;
        int endX=-1,endY=-1;
        boolean flag1=false,flag2=false;
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (data[i][j]==1)
                {
                    startX=i;
                    startY=j;
                    flag1=true;

                }
                if (data[i][j]==2)
                {
                    endX=i;
                    endY=j;
                    flag2=true;
                }
                if (flag1&&flag2)
                    break;
            }
        }
        if (endX==-1||startX==-1) {
            System.out.println("No Paths");
            System.exit(100);
        }
        System.out.println("Total Paths "+ handler.uniquepaths(startX,startY,endX,endY));
        System.out.println("Total Call Escaped are "+handler.counter);
    }
}

