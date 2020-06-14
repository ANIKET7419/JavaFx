package Comp_P.Dynamic_Programming;

import java.util.Scanner;
/*
This question is used to find the maximum value of an array  continguously
 */
class mx_subarray_handler
{
    int data[];
    void input(int data[])
    {
        this.data=data;
    }
    int solution()
    {
        int storage[]=new int[data.length];
        for (int i=0;i<data.length;i++)
        {
            if(i==0)
                storage[i]=data[i];
            else {
                storage[i]=Math.max(data[i] + storage[i - 1], data[i]);
            }
        }
        int max=storage[0];
        for (int i=1;i<data.length;i++)
        {
            System.out.print(storage[i]+" , ");
            max= max<storage[i]?storage[i]:max;
        }
        System.out.println();


        return max;

    }
}

public class mx_subarray {


    public static void main(String[] args) {
        mx_subarray_handler handler=new mx_subarray_handler();
        int n;
        System.out.println("Enter the size");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        int data[]=new int[n];
        System.out.println("Enter Data");
        for (int i=0;i<n;i++)
        {
            data[i]=scanner.nextInt();
        }
        handler.input(data);
        System.out.println("The Largest sum  is "+handler.solution());
    }
}
