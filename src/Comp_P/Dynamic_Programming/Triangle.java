package Comp_P.Dynamic_Programming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 */
class TriangleHandler
{

    List<List<Integer>> triangle;
    void input(List<List<Integer>> triangle)
    {
        this.triangle=triangle;
    }
    int minimumPathSum(int index,int row)
    {
        if (row==triangle.size()-1)
            return triangle.get(row).get(index);
       int temp= minimumPathSum(index,row+1)+triangle.get(row).get(index);
       int temp1= minimumPathSum(index+1,row+1)+triangle.get(row).get(index);
       return Math.min(temp,temp1);
    }
}
public class Triangle {
    public static void main(String[] args) {
        TriangleHandler handler=new TriangleHandler();
        System.out.println("Enter Number Of rows");
        Scanner scanner=new Scanner(System.in);
        int rows=scanner.nextInt();
        List<List<Integer>> triangle=new ArrayList();
        System.out.println("Enter Data ");
        for (int i=0;i<rows;i++)
        {
            List<Integer> row=new ArrayList<Integer>();
            for (int j=0;j<=i;j++)
            {
                int el=scanner.nextInt();
                row.add(el);
            }
            triangle.add(row);
        }
        handler.input(triangle);
        System.out.println("The Minimum Cost is "+handler.minimumPathSum(0,0));
    }
}
