package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class coin_handler
{
    int n;
    int data[]={1,2,5};
    int storage[][];
    int counter=0;
 void input(int n)
 {
     this.n=n;
     storage=new int[n+1][data.length+1];
     for(int i=0;i<n;i++)
     {
         for(int j=0;j<data.length;j++)
         {
             storage[i][j]=-1;
         }
     }
 }
 int  combination(int total_sum,int index)
 {

     if(total_sum==n)
     {
         storage[total_sum][index]=1;
         return 1;
     }
     if(total_sum>n)
         return 0;

     if(storage[total_sum][index]!=-1) {
         counter++;
         return storage[total_sum][index];
     }
     int sum=0;
     for(int i=index;i<data.length;i++)
     {

         sum+=combination(data[i]+total_sum,i);

     }

  storage[total_sum][index]=sum;
   return sum;
 }


}
public class coin_change {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter the amount");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        coin_handler object=new coin_handler();
        object.input(n);
        System.out.println("Total Number of ways "+object.combination(0,0));
        System.out.println("Total Call Escaped  is "+object.counter++);
    }
}
