package Comp_P.BruteForce.Backtracking;
import javafx.util.Pair;
import java.util.HashMap;
import java.util.Scanner;



//Under Progress
class SudokuSolverHandler
{
    char data[][];
     HashMap<Character,Integer> row[],column[],grid[][];
    void input(char data[][])
    {
        row=new HashMap[9];
        column=new HashMap[9];
        grid=new HashMap[3][3];
        this.data=data;
    }
    boolean isSafe(int i,int j)
    {
        if (row[i].containsKey(data[i][j])) {
            row[i].put(data[i][j], row[i].get(data[i][j]) + 1);
            return false;
        }
        else
        {
            row[i].put(data[i][j], 1);
        }
        if(column[j].containsKey(data[i][j])) {
            column[j].put(data[i][j], column[j].get(data[i][j]) + 1);
            return false;
        }
        else {
            column[j].put(data[i][j],  1);
        }
        if (grid[i/3][j/3].containsKey(data[i][j])) {
            grid[i / 3][j / 3].put(data[i][j], grid[i / 3][j / 3].get(data[i][j]) + 1);
            return false;
        }
        else
        {
            grid[i / 3][j / 3].put(data[i][j],  1);
        }
        return true;
    }
    void  solver(int i,int j)
    {
        if (i==data.length-1&&j==data[0].length)
        {
            for(int i1=0;i1<10;i1++)
            {
                for(int j1=0;j1<10;j1++)
                {
                    System.out.print(data[i1][j1]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        if (j==9)
        {
            i=i+1;
            j=0;
        }
        if(data[i][j]!='.')
        {
            solver(i,j+1);
        }
        else  if (isSafe(i,j))
        {
            for(int value=1;value<=9;value++)
            {
                data[i][j]=(char)(value+48);
                solver(i,j+1);
                data[i][j]='.';
            }
        }


    }


}

public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolverHandler handler=new SudokuSolverHandler();
        char data[][]=new char[9][9];
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Data");
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                data[i][j]=scanner.nextLine().charAt(0);
            }
        }
        handler.solver(0,0);
    }
}
