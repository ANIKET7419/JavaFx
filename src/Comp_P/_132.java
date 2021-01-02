package Comp_P;

import java.util.Scanner;

public class _132 {
    public static  boolean isIt(int data[])
    {

        int i[]=new int[data.length];
        int j[]=new int[data.length];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int k=0;k<data.length;k++)
        {
            min=Math.min(min,data[k]);
            max=Math.max(max,data[k]);
            i[k]=min;
            j[k]=max;
        }
        for(int k=0;k<data.length;k++)
        {
        }
        // i will do it later
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of elements ");
        int n=scanner.nextInt();
        System.out.println("Enter data");
        int data[]=new int[n];
        for (int i=0;i<n;i++)
            data[i]=scanner.nextInt();
        System.out.println("Is there any 132 subsequence : "+isIt(data));

    }
}
