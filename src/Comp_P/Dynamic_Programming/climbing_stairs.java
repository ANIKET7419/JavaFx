package Comp_P.Dynamic_Programming;
/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */


import java.util.Scanner;

class climbing_handler
{
    int n;
    int data[]={1,2};
    int storage[];
    int counter=0;
    void input(int n)
    {
        this.n=n;
        storage=new int[n+1];
        for (int i=0;i<n;i++)
        {
            storage[i]=-1;
        }
    }
    int  recursive(int total_sum)
    {
        if(total_sum==n)
        {
            storage[total_sum]=1;
            return 1;
        }
        if(total_sum>n)
            return 0;
        if(storage[total_sum]!=-1)
        {
            counter++;
            return storage[total_sum];
        }
        int sum=0;
        for(int i=0;i<2;i++)
        {
            sum+=recursive(total_sum+data[i]);
        }
        storage[total_sum]=sum;
        return sum;
    }

}
public class climbing_stairs {
    public static void main(String[] args) {
        climbing_handler object=new climbing_handler();
        int n;
        System.out.println("Enter total steps");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        object.input(n);
        System.out.println("Total Ways are "+object.recursive(0));
        System.out.println("Total Call Escaped are "+object.counter);
    }
}
