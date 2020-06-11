package Comp_P;
import java.util.Scanner;

class knap_handler
{
    int capacity;
    int total_items;
    int times=0;
    public int storage[][];
    int  weight[];
    int profit[];
    void input(int profit[],int weight[],int total_items,int capacity)
    {
        this.weight=weight;
        this.profit=profit;
        this.total_items=total_items;
        this.capacity=capacity;
        storage=new int[this.total_items+1][this.capacity+1];
    }
    void  initiate()
    {
        for(int i=0;i<total_items+1;i++)
        {
            for (int j=0;j<capacity+1;j++)
            {
                storage[i][j]=-1;
            }
        }


    }
    int  recursive(int i,int j)
    {
         if(i==0||j==0)
         {
             storage[i][j]=0;
             return 0;
         }
         if(storage[i][j]!=-1)
         {
             times++;
             return storage[i][j];
         }
         if(j>=weight[i-1]) {
             int exclude_profit = recursive(i-1, j);
             int include_profit = recursive(i-1, j - weight[i - 1])+profit[i-1];
             if (include_profit > exclude_profit) {
                 storage[i][j] = include_profit;
             }
             else
                 {
                 storage[i][j] = exclude_profit;
             }
         }
         else
         {
             storage[i][j]=recursive(i-1,j);
         }
         return storage[i][j];
    }



}


public class knapsack {

    public static void main(String[] args) {
        int capacity;
        int total_items;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Knapsack Capacity");
        capacity=scanner.nextInt();
        System.out.println("Enter Total Items");
        total_items=scanner.nextInt();
        int  weight[]=new int[total_items];
        int profit[]=new int[total_items];
        System.out.println("Enter profit and weight--> ");
        for (int i=0;i<total_items;i++)
        {
            profit[i]=scanner.nextInt();
            weight[i]=scanner.nextInt();

        }
        knap_handler object=new knap_handler();
        object.input(profit,weight,total_items,capacity);
        object.initiate();
        System.out.println("The Result is "+object.recursive(total_items,capacity));
        for(int i=0;i<total_items+1;i++)
        {
            for (int j=0;j<capacity+1;j++)
            {
                System.out.print(object.storage[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println("Total Call That is not happenend again "+object.times);
    }
}
