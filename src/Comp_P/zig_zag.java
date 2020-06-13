package Comp_P;

import java.util.Scanner;

class zig_zag_handler
{
    int data[];
    void input(int data[])
 {
    this.data=data;
 }
  int [] zig_zag()
  {
      boolean flag=true;
      for(int i=0;i<data.length-1;i++)
      {
          if(flag)
          {
              if(data[i]>data[i+1])
              {
                  int temp=data[i];
                  data[i]=data[i+1];
                  data[i+1]=temp;
              }
              flag=false;
          }
          else
          {
              if(data[i]<data[i+1])
              {
                  int temp=data[i];
                  data[i]=data[i+1];
                  data[i+1]=temp;
              }
              flag=true;
          }
      }

  return data;
  }
}
public class zig_zag {
    public static void main(String[] args) {
        zig_zag_handler handler=new zig_zag_handler();
        int n;
        System.out.println("Enter Length");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        int data[]=new int[n];
        System.out.println("Enter Data");
        for(int i=0;i<n;i++)
        {
            data[i]=scanner.nextInt();
        }
        handler.input(data);
        int result[]=handler.zig_zag();
        System.out.println("Result ---->>>>>>");
        for(int i=0;i<result.length;i++)
        {
            System.out.print(result[i]+"  ,  ");
        }
        System.out.println();

    }
}
