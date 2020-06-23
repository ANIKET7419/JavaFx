package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class BurstBaloonHandler{
    int data[];
    void input(int data[])
    {
        this.data=data;
    }
    int maximumprofit(int i,int j)
    {
        int profit=Integer.MIN_VALUE;
        if(i==j)
        {


            if (i+1==data.length)
            {
                return data[i]*data[i-1];
            }
            else if (i==0)
            {
                return data[i]*data[i+1];
            }
            else
                return data[i]*data[i+1]*data[i-1];

        }
        else if (i>j)
        {
            return 0;
        }
        else
        {
          for (int k=i;k<=j;k++)
          {
              int temp;
              if (j+1==data.length&&i==0)
              {
                  temp=data[k]+maximumprofit(i,k-1)+maximumprofit(k+1,j);
              }
              else if (j+1!=data.length&&i==0)
              {
                  temp=data[k]*data[j+1]+maximumprofit(i,k-1)+maximumprofit(k+1,j);
              }
              else if (j+1==data.length&&i!=0)
                  temp=data[k]*data[i-1]+maximumprofit(i,k-1)+maximumprofit(k+1,j);
              else
                  temp=data[k]*data[i-1]*data[j+1]+maximumprofit(i,k-1)+maximumprofit(k+1,j);
              if (profit<temp)
                  profit=temp;
          }
        }
        return profit;
    }
}
public class BurstBaloon {


    public static void main(String[] args) {
        BurstBaloonHandler handler=new BurstBaloonHandler();
        System.out.println("Enter number of baloons");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println("Enter their profit");
        int data[]=new int[n];
        for(int i=0;i<n;i++)
            data[i]=scanner.nextInt();
        handler.input(data);
        System.out.println("The Maximum profit is "+handler.maximumprofit(0,data.length-1));
    }
}
