package Comp_P.Dynamic_Programming;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

class JumpGameHandler
{
    int data[];
    int storage[][];
    void input(int data[])
    {
        this.data=data;
        storage=new int[data.length][data.length];
        for (int temp[]:storage)
        {
            Arrays.fill(temp,-1);
        }
    }
    int minimumjump()
    {
        int minimum_jump=0;
        for (int i=0;i<data.length;i++)
        {
            for (int j=0;j<data.length;j++)
            {
                if(i==j)
                    storage[i][j]=0;
                else if(i>j)
                    storage[i][j]=-1;
                else {
                    if(data[i]+i>=j)
                        storage[i][j]=storage[0][j]+1;
                    else
                    {
                        if(data[j-1]+j-1>=j)
                        storage[i][j]=storage[0][j-1]+1;
                        else
                            storage[i][j]=-1;
                    }
                }
            }
        }
        for (int i=0;i<data.length;i++)
        {
            for (int j=0;j<data.length;j++)
            {
                System.out.print(storage[i][j]+" ");
            }
            System.out.println();
        }


        return minimum_jump;
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
        handler.minimumjump();


    }
}
