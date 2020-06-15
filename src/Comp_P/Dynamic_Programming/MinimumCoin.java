package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class MiniMumCoin
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
    int  combination(int total_sum,int index,int minimum_coins)
    {

        if(total_sum==n)
        {
            storage[total_sum][index]=minimum_coins;
            return minimum_coins;
        }
        if(total_sum>n)
            return -1;

        if(storage[total_sum][index]!=-1) {
            counter++;
            return storage[total_sum][index];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=index;i<data.length;i++)
        {
           int temp=combination(total_sum+data[i],i,minimum_coins+1);
           if(temp<ans&&temp!=-1)
           {
               ans=temp;
           }


        }

        storage[total_sum][index]=ans;
        return ans;
    }


}
public class MinimumCoin {
    public static void main(String[] args) {
        MiniMumCoin object=new MiniMumCoin();
        int n;
        System.out.println("Enter the amount");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        object.input(n);
        System.out.println("Minimum Coins Required "+object.combination(0,0,0));
        System.out.println("Total Call Escaped  is "+object.counter++);
    }
}
