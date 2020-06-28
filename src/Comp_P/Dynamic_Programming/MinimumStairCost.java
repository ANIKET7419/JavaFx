package Comp_P.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

class MinimumStairCostHandler
{
    int data[];
    int storage[];
    void input(int data[])
    {
        this.data=data;
        storage=new int[data.length+1];
        Arrays.fill(storage,-1);
    }
    int minimumCost(int index)
    {
        if (index==data.length-1)
        {
            return data[index];
        }
        if (index>=data.length)
        {
            return 0;
        }
        if (storage[index]!=-1)
            return storage[index];
        int result;
       int temp1= minimumCost(index+1);
       int temp2= minimumCost(index+2);
           result=Math.min(temp1+data[index],temp2+data[index]);

       return storage[index]=result;
    }


}
public class MinimumStairCost {
    public static void main(String[] args) {
        MinimumStairCostHandler handler =new MinimumStairCostHandler();
        int n;
        System.out.println("Enter the size ");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        System.out.println("Enter Data");
        int data[]=new int[n];
        for (int i=0;i<n;i++)
            data[i]=scanner.nextInt();
        handler.input(data);
        System.out.println("The Minimum cost is "+Math.min(handler.minimumCost(0),handler.minimumCost(1)));
    }
}
