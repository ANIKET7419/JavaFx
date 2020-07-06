package Comp_P.Dynamic_Programming;
import java.util.Scanner;
//Under Progress  the best way to do is https://web.archive.org/web/20160120093629/http://algobox.org/create-maximum-number/
class BuildMaximumNumberHandler
{

    int data1[],data2[];
    int k;
     void input(int data1[],int data2[],int k)
     {
         this.data1=data1;
         this.data2=data2;
         this.k=k;
     }

     int [] one_d_array(int data1[],int k)
     {
         int result[]=new int[k];
         int j=0;
         for (int i=0;i<data1.length;i++) {
             while (j > 0 && result[j - 1] < data1[i] && data1.length - i + j > k)
                 j--;
             if (j < k)
                 result[j++] = data1[i];
         }
         return result;
     }
     int [] merge(int[] data1, int data2[])
     {
         int r=0;
         int i=0,j=0;
         int result[]=new int[data1.length+data2.length];
           while (r<data1.length+data2.length)
           {
             result[r++]= forfirst_or_not(data1,i,data2,j)?data1[i++]:data2[j++];
           }
           return result;
     }
    boolean forfirst_or_not(int[] data1,int i, int data2[],int j)
    {
        while (i<data1.length&&j<data2.length)
        {
            if (data1[i]==data2[j]) {
                i++;
                j++;
            }
            else if (data1[i]>data2[j])
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return true;


    }

     int [] maximumNumber(){

           if (data1.length+data2.length<k)
               return new int[]{};



            int ans[]=new int[k];
           for (int i=Math.max(0,k-data2.length);i<k&&i<data1.length;i++)
           {
              int candidate[]= merge(one_d_array(data1,i),one_d_array(data2,k-i));
              if (forfirst_or_not(candidate,0,ans,0))
              {
                  ans=candidate;
              }
           }

         return ans;
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
          handler.input(data1.clone(),data2.clone(),k);
        int result[]= handler.maximumNumber();
        for (int i=0;i<result.length;i++)
        {
            System.out.print(result[i]+"  ");
        }
         System.out.println();

    }
}
