package Comp_P.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class IntegerBreakHandler
{
    int counter=0;
    int storage[];
    void input(int n)
    {
        storage=new int[n+1];
        Arrays.fill(storage,-1);
    }
    int maximum(int k)
    {

        int Max=Integer.MIN_VALUE;
        if (k<0)
            return 1;
        if (k==1)
            return 1;
        if (storage[k]!=-1) {
            counter++;
            return storage[k];
        }
        for (int i=k-1;i>=1;i--)
        {
            int val=(k-i)*maximum(i);
            if(val<(k-i)*i)
                val=(k-i)*i;
            if (val>Max)
                Max=val;
        }

        return storage[k]=Max;
    }
}
public class IntegerBreak {
    public static void main(String[] args) {
        IntegerBreakHandler handler=new IntegerBreakHandler();
        int n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Integer Value");
        n=scanner.nextInt();
        handler.input(n);
        System.out.println("The Maximum product is "+handler.maximum(n));
        System.out.println("Total Call Escaped "+handler.counter);
    }
}
