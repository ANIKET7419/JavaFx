package Comp_P.BruteForce.Backtracking;
import java.util.HashSet;
import java.util.Scanner;
class SudokuSolverHandler
{
    char data[][];
    HashSet<Character>[] row;
    HashSet<Character>[] column;
    HashSet<Character>[][] grid;
    void input(char data[][])
    {
        row=new HashSet[9];
        column=new HashSet[9];
        grid=new HashSet[3][3];
        this.data=data;
        for(int i=0;i<9;i++)
        {
            row[i]=new HashSet();
            column[i]=new HashSet();

        }
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                grid[i][j]=new HashSet();
    }


    void  put(int i,int j)
    {
        row[i].add(data[i][j]);
        column[j].add(data[i][j]);
        grid[i / 3][j / 3].add(data[i][j]);
    }
    void remove(int i,int j)
    {

        row[i].remove(data[i][j]);
        column[j].remove(data[i][j]);
        grid[i/3][j/3].remove(data[i][j]);
    }
    boolean  solver(int i,int j)
    {


        if (i==8&&j==9)
        {
            return true;
        }
       else  if (j==9)
        {
            i=i+1;
            j=0;
        }
        if(data[i][j]!='.')
        {

            if (row[i].contains(data[i][j])||column[j].contains(data[i][j])||grid[i/3][j/3].contains(data[i][j]))
                return false;
            put(i,j);
            if(solver(i,j+1))
                return true;
            remove(i,j);
        }
        else {
            for (int value = 1; value <= 9; value++) {

                char temp = (char) (value + 48);
                if (!row[i].contains(temp)&& !column[j].contains(temp)&&!grid[i / 3][j / 3].contains(temp))
                {

                    data[i][j] =temp;
                    put(i,j);
                    if(solver(i, j + 1))
                        return true;
                    remove(i,j);
                    data[i][j] = '.';
                }

            }
        }
        return false;
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
        handler.input(data.clone());
        handler.solver(0,0);
    }
}
