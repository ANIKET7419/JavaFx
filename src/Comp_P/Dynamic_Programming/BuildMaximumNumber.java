package Comp_P.Dynamic_Programming;
import Comp_P.Reusable.SegmentTree;
import java.util.Scanner;
public class BuildMaximumNumber {
    public static void main(String[] args) {
          SegmentTree tree=new SegmentTree();
          System.out.println("Enter Data Length");
          Scanner scanner=new Scanner(System.in);
         int n=scanner.nextInt();
         int data[]=new int[n];
        System.out.println("Enter Data ");
        for (int i=0;i<n;i++)
            data[i]=scanner.nextInt();
        tree.input(data);
        tree.construct();
        while (true)
        {
            System.out.println("Start");
            int start=scanner.nextInt();
            System.out.println("End");
            int end=scanner.nextInt();
            int result[]=tree.queryMax(start,end);
            System.out.println("The Result is "+result[0]+"  of Index "+result[1]);

        }

    }
}
