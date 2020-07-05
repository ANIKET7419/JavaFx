package Comp_P.Dynamic_Programming;
import Comp_P.Reusable.SegmentTree;
import java.util.Scanner;
class BuildMaximumNumberHandler
{

    int data1[],data2[];
    int result[];
    int k;
    int length;
     void input(int data1[],int data2[],int k)
     {
         this.data1=data1;
         this.data2=data2;
         result=new int[k];
         this.k=k;
         length=k;
     }
     int[] maximumNumber()
     {
          if (data1.length+data2.length<k)
              return new int[]{};
          SegmentTree tree1=new SegmentTree();
          SegmentTree tree2=new SegmentTree();
          tree1.input(data1);
          tree2.input(data2);
          tree1.construct();
          tree2.construct();
          int data1start=0;
          int data1end=data1.length-1;
          int data2start=0;
          int data2end=data2.length-1;
         while (k!=0&&data1start<data1end&&data2start<data2end)
         {
             int temp1[]=tree1.queryMax(data1start,data1end);
             int temp2[]=tree2.queryMax(data2start,data2end);
             if (temp1[0]>temp2[0])
             {
                int remaining_elements= data1end-temp1[1];
                int others=data2end-data2start+1;
                if (remaining_elements+others>=k)
                {

                    result[length-k]=temp1[0];
                    k--;

                    data1start=temp1[1]+1;

                }
                else
                {
                    data1end=temp1[1]-1;
                }
             }
             else if (temp1[0]==temp2[0])
             {
                 int remaining_elements= data1end-temp1[1];
                 int others=data2end-data2start+1;
                 if (remaining_elements+others>=k)
                 {
                     result[length-k]=temp1[0];
                     k--;
                     data1start=temp1[1]+1;

                 }
                 else
                 {
                  int remaining=data2end-temp2[1];
                  int other=data1end-data1start+1;
                  if (remaining+other>=k)
                  {
                      result[length-k]=temp2[0];
                      k--;
                      data2start=temp2[1]+1;

                  }
                  else {

                      data1end=temp1[1]-1;
                  }
                 }
             }
             else {

                 int remaining_elements= data2end-temp2[1];
                 int others=data1end-data1start+1;
                 if (remaining_elements+others>=k)
                 {
                     result[length-k]=temp2[0];
                     k--;
                     data2start=temp2[1]+1;

                 }
                 else
                 {
                     data2end=temp2[1]-1;
                 }
             }
         }


      return result;
     }


}
public class BuildMaximumNumber {
    public static void main(String[] args) {
          BuildMaximumNumberHandler handler =new BuildMaximumNumberHandler();
          int n1,n2;
          System.out.println("Enter The length of 1st Array");
          Scanner scanner=new Scanner( System.in);
          n1=scanner.nextInt();
          System.out.println("Enter the length of 2nd Array");
          n2=scanner.nextInt();
          System.out.println("Enter data for 1st ");
          int data1[]=new int[n1];
          int data2[]=new int[n2];
          for (int i=0;i<n1;i++)
              data1[i]=scanner.nextInt();
          System.out.println("Enter the dta for 2nd ");
          for (int i=0;i<n2;i++)
              data2[i]=scanner.nextInt();
          System.out.println("Enter the value of k");
          int k=scanner.nextInt();
          handler.input(data1,data2,k);
          int result[]=handler.maximumNumber();
          for (int i=0;i<result.length;i++)
              System.out.print(result[i]+"  , ");




    }
}
