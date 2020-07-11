package Comp_P;

import java.util.Arrays;
import java.util.Scanner;

/*


Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

X X X X
X O O X
X X O X
X O X X


After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X



Approach:->
for every place where 0 Exist we will check recursively whether in all direction there exists X at any position util border comes




 */
class SurroundedRegionsHandler
{
   char board[][];
   boolean isvisited[][];
    void input(char board[][])
    {
     this.board=board;
     isvisited=new boolean[board.length][board[0].length];
     for (boolean temp[]:isvisited)
         Arrays.fill(temp,false);
    }
    byte needtoflip(int x,int y)
    {
        if (x>=board.length||x<0||y>=board[0].length||y<0)
            return 0;
        if (board[x][y]=='X')
            return 1;
        if (isvisited[x][y])
            return -1;
        isvisited[x][y]=true;
        byte t1= needtoflip(x+1,y);
        byte t2=needtoflip(x,y+1);
        byte t3=needtoflip(x-1,y);
        byte t4=needtoflip(x,y-1);
        isvisited[x][y]=false;
        if (t1==-1||t2==-1||t3==-1||t4==-1)
        {
             byte result=-1;
            if(t1!=-1)
               result= t1==1&&result!=0?(byte)1:0;
            if (t2!=-1)
                result= t2==1&&result!=0?(byte)1:0;
             if (t3!=-1)
                result=t3==1&&result!=0?(byte)1:0;
            if (t4!=-1)
                result= t4==1&&result!=0?(byte)1:0;
            return result;
        }
        else
        {
            if (t1==1&&t2==1&&t3==1&&t4==1)
                return 1;
            else
                return 0;
        }

    }
    void flip()
    {
      for (int i=0;i<board.length;i++)
      {
          for (int j=0;j<board[0].length;j++)
          {
              if (board[i][j]=='O')
              {
                if (needtoflip(i,j)==1)
                {
                    board[i][j]='X';
                }
              }
          }
      }

    }
}
public class SurroundedRegions {
    public static void main(String[] args) {
    SurroundedRegionsHandler handler=new SurroundedRegionsHandler();
       System.out.println("Enter Number of Rows ");
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        System.out.println("Enter Number Of Columns ");
        int n=scanner.nextInt();
        System.out.println("Enter Data ");
        char board[][]=new char[m][n];
        Scanner scanner1=new Scanner(System.in);
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {

                board[i][j]=scanner1.nextLine().charAt(0);
            }
        }
        handler.input(board);
        handler.flip();
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
