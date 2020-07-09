package Comp_P.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

class OutOfBoundaryHandler
{
    int places[][];
    void input(int m,int n)
    {
        places=new int[m][n];
        for (int temp[]:places)
            Arrays.fill(temp,0);
    }
    boolean safe(int currentx,int currenty)
    {

        if (places[currentx][currenty]==1)
            return false;
        else
            return true;
    }

    int paths(int currentx,int currenty,int moves)
    {

       if (currentx>=places.length||currenty>=places[0].length||currentx<0||currenty<0)
           return 1;
       if (moves==0)
           return 0;
       int result=0;
       if (safe(currentx,currenty))
       {
           places[currentx][currenty]=1;
           result+=paths(currentx+1,currenty,moves-1);
           result+=paths(currentx,currenty+1,moves-1);
           result+=paths(currentx-1,currenty,moves-1);
           result+=paths(currentx,currenty-1,moves-1);
       }
       return result;
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
        handler.input(m,n);
        System.out.println("The Total Paths are "+handler.paths(x,y,moves));

    }
}
