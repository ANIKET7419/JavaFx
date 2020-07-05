package Comp_P.Dynamic_Programming;
import Comp_P.Reusable.SegmentTree;
import java.util.Scanner;
//Under Progress
class BuildMaximumNumberHandler
{

    int data1[],data2[];
    int result[];
    int k;
    int length;
    boolean flag=false;
    SegmentTree tree1,tree2;
     void input(int data1[],int data2[],int k)
     {
         this.data1=data1;
         this.data2=data2;
         tree1=new SegmentTree();
         tree1.input(data1);
         tree1.construct();
         tree2=new SegmentTree();
         tree2.input(data2);
         tree2.construct();
         result=new int[k];
         this.k=k;
         length=k;

     }
     void maximumNumber(int start1,int end1,int start2,int end2,int k)
     {

         if (start1>end1||start2>end2)
             return;
         else   if ((end1-start1+1)+(end2-start2+1)<k)
             return;
         if (k==0)
         {
             flag=true;
             return;
         }

         int maximum1[]=tree1.queryMax(start1,end1);
         int maximum2[]=tree2.queryMax(start2,end2);
        if (maximum1[0]>maximum1[0])
        {
            result[length-k]=maximum1[0];
            maximumNumber(maximum1[1]+1,end1,start2,end2,k-1);
            maximumNumber(start1,maximum1[1]-1,start2,end2,k);

        }
       else if (maximum1[0]==maximum2[0])
       {
           result[length-k]=maximum1[0];
           maximumNumber(maximum1[1]+1,end1,start2,end2,k-1);
           result[length-k]=maximum2[0];
           maximumNumber(start1,end1,maximum2[0]+1,end2,k-1);

       }
       else {


       }

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
          System.out.println("Enter the data for 2nd ");
          for (int i=0;i<n2;i++)
              data2[i]=scanner.nextInt();
          System.out.println("Enter the value of k");
          int k=scanner.nextInt();
          handler.input(data1,data2,k);
          //int result[]=handler.maximumNumber();
          //for (int i=0;i<result.length;i++)
           //   System.out.print(result[i]+"  , ");




    }
}
/*


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

 */