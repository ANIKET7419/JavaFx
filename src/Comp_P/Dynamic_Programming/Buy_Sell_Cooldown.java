package Comp_P.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

class Buy_Sell_CooldownHandler
{
    int data[];
    int storage[][];
    void input(int data[])
    {
        this.data=data;
        storage=new int[2][data.length];
        Arrays.fill(storage[1],-1);
    }

    int maximumprofit(int i,int j)
    {
        if (j==0||i==0||i<0||j<0)
        {
            if (i!=0&&j==0||i<0||j<0)
                return 0;
            else
            {
                return -data[j];
            }
        }
        if(storage[i][j]!=-1)
            return storage[i][j];
        int max=Integer.MIN_VALUE;
        for (int k=j-1;k>=0;k--)
        {
            int temp=maximumprofit(i-1,k)+maximumprofit(i,k-2)+data[j];
            if (temp>max)
                max=temp;
        }

        int temp2=maximumprofit(i,j-1);
        if (max<temp2)
            max=temp2;
        return storage[i][j]=max;
    }



}
public class Buy_Sell_Cooldown {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter Number Of Days");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        System.out.println("Enter Cost");
        int data[]=new int[n];
        for (int i=0;i<n;i++)
        {
            data[i]=scanner.nextInt();
        }
        Buy_Sell_CooldownHandler handler =new Buy_Sell_CooldownHandler();
        handler.input(data.clone());
        System.out.println("The Maximum Profit is "+handler.maximumprofit(1,data.length-1));

    }
}
