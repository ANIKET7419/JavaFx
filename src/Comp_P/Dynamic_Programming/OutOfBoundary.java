package Comp_P.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;
/*

There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.
 */
class OutOfBoundaryHandler
{
    int storage[][][];
    int counter=0;
    int m,n;
    final static int mod=1_00_00_00_00_7;
    void input(int m,int n,int moves)
    {
        this.m=m;
        this.n=n;
        storage=new int[m][n][moves+1];
        for (int temp[][]:storage)
            for (int temp1[]:temp)
                Arrays.fill(temp1,-1);
    }

    int paths(int currentx,int currenty,int moves)
    {

        if (currentx>=m||currenty>=n||currentx<0||currenty<0)
            return 1;
        if (moves==0)
            return 0;
        if (storage[currentx][currenty][moves]!=-1) {
            counter++;
            return storage[currentx][currenty][moves];
        }
        int result=0;
        result=(result+paths(currentx+1,currenty,moves-1))%mod;
        result=(result+paths(currentx,currenty+1,moves-1))%mod;
        result=(result+paths(currentx-1,currenty,moves-1))%mod;
        result=(result+paths(currentx,currenty-1,moves-1))%mod;
        return storage[currentx][currenty][moves]=result%mod;
    }
}

public class OutOfBoundary {

    public static void main(String[] args) {
        OutOfBoundaryHandler handler=new OutOfBoundaryHandler();
        System.out.println("Enter Number of Rows ");
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        System.out.println("Enter Number Of Columns");
        int n=scanner.nextInt();
        System.out.println("Enter Current X");
        int x=scanner.nextInt();
        System.out.println("Enter Current Y");
        int y=scanner.nextInt();
        System.out.println("Enter Total Moves");
        int moves=scanner.nextInt();
        handler.input(m,n,moves);
        System.out.println("The Total Paths are "+handler.paths(x,y,moves));
        System.out.println("Total Call Escaped "+handler.counter);

    }
}
