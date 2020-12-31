package Comp_P;

import java.util.Scanner;


public class _132 {
    public static  boolean isIt(int data[])
    {
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
