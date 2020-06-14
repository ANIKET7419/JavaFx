package Comp_P;

import java.util.Scanner;
/*
This question is quite different it is used to find the maximum value of an array non continguously
 */
class mx_subarray
{
    int data[];
    void input(int data[])
    {
        this.data=data;
    }
    int solution()
    {
      int storage[]=new int[data.length];
      for (int i=0;i<data.length;i++)
      {
          if(i==0)
          storage[i]=data[i];
          else {
              int temp = Math.max(data[i] + storage[i - 1], storage[i - 1]);
              storage[i]=Math.max(data[i],temp);
          }
      }
      return storage[data.length-1];

    }
}
public class mximum_subarray {
    public static void main(String[] args) {
        mx_subarray handler=new mx_subarray();
        int n;
        System.out.println("Enter the size");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        int data[]=new int[n];
        System.out.println("Enter Data");
        for (int i=0;i<n;i++)
        {
            data[i]=scanner.nextInt();
        }
        handler.input(data);
        System.out.println("The Largest sum  is "+handler.solution());
    }
}
