/*Brute Force is also available.
Read there its description now it is with dynamic programming
 */
package Comp_P.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

class FrogJumpMemoHandler
{
    int counter=0;
    int data[];
    byte storage[][];
    void input(int data[])
    {
        this.data=data;
        storage=new byte[data.length][data.length];
        for (byte temp[]:storage)
        {
            Arrays.fill(temp, (byte) -1);
        }
    }
    boolean ispossible(int jump,int index)
    {
        if(index>=data.length-1) {
            storage[jump][index]=1;
            return true;
        }
        else {
            if (storage[jump][index]!=-1) {
                counter++;
                return storage[jump][index] == 1;
            }
            boolean flag=false;
            int index_to_jump=-1;
            for (int j=index+1;j<data.length;j++)
            {
                if(data[index]+jump==data[j])
                {
                    index_to_jump=j;
                    flag=true;
                }
                if (data[index]+jump<data[j])
                {
                    break;
                }
            }
            if (!flag) {
                storage[jump][index]=0;
                return false;
            }
            else
            { boolean temp= ispossible(jump - 1, index_to_jump) || ispossible(jump, index_to_jump) || ispossible(jump + 1, index_to_jump);
             storage[jump][index]=temp?(byte)1:(byte)0;
             return temp;
            }
        }
    }


}
public class FrogJumpMemo {
    public static void main(String[] args) {
        FrogJumpMemoHandler handler=new FrogJumpMemoHandler();
        System.out.println("Enter Number of  Stones ");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int data[]=new int[n];
        System.out.println("Enter Stones' Positions");
        for (int i=0;i<n;i++)
            data[i]=scanner.nextInt();
        handler.input(data);
        System.out.println("Possible or Not "+handler.ispossible(1,0));
        System.out.println("The Total Call Escaped "+handler.counter);
    }
}




