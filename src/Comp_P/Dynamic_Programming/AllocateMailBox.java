package Comp_P.Dynamic_Programming;

import java.util.Scanner;

public class AllocateMailBox {
    public static  int distance(int street[],int k,int loc)
    {

// i' ll do later
        if(k==0)
        {
            return 0;
        }
return 100;


    }

    public static void main(String[] args) {
        System.out.println("Enter number of  houses");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println("Enter their locations");
        int houses[]=new int[n];
        for (int i=0;i<n;i++)
            houses[i]=scanner.nextInt();
        System.out.println("Enter the value of k");
        int k=scanner.nextInt();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            max=Math.max(max,houses[i]);
        int street[]=new int[max+1];
        for(int i=0;i<n;i++)
            street[houses[i]]=2;
        System.out.println("The minimum distance is "+distance(street,k,1));
    }
}
