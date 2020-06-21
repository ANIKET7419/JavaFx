package Comp_P.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

class JumpGameHandler
{
    int data[];
    int storage[];
    void input(int data[])
    {
        this.data=data;
        storage=new int[data.length];
        Arrays.fill(storage,-1);
    }
    int minimumjump()
    {

        storage[0]=0;
        for (int i =1;i<data.length;i++)
        {
            int min=Integer.MAX_VALUE;
            for (int j=i-1;j>=0;j--)
            {
                if(data[j]+j>=i)
                {
                    if(min>storage[j])
                    {
                        min=storage[j];
                    }
                }

            }
            if(min==Integer.MAX_VALUE)
            {
                storage[i]=0;
            }
            else {
                storage[i]=min+1;
            }
        }


        return storage[data.length-1];
    }
}
public class JumpGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        JumpGameHandler handler=new JumpGameHandler();
        int []data;
        System.out.println("Enter Length of the data");
        int n=scanner.nextInt();
        data=new int[n];
        System.out.println("Enter Data");
        for (int i=0;i<n;i++)
        {
            data[i]=scanner.nextInt();
        }
        handler.input(data);
        int result=handler.minimumjump();
        System.out.println("The Minimum steps is "+(result==0&&data.length>1?-1:result));


    }
}
