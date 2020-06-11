package Comp_P;


import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
class  p_handler_with_m
{
    String string;
    int storage[][];
   int times=0;
    void input(@NotNull String string)
    {
        this.string=string;
        storage=new int[string.length()][string.length()];
        for(int i=0;i<string.length();i++)
        {
            for(int j=0;j<string.length();j++)
            {
                storage[i][j]=-1;
            }
        }
    }
    boolean ispalindrome(int i,int j)
    {
        if(i>=j)
            return true;
        else {
            if(string.charAt(i)==string.charAt(j)) {
                return ispalindrome(i + 1, j - 1);
            }
            else
                return false;
        }

    }

    int recursive(int i,int j)
    {
        if(i>=j)
        {
            storage[i][j]=0;
            return 0;
        }
        if(ispalindrome(i,j))
        {
            storage[i][j]=0;
            return 0;
        }
        if(storage[i][j]!=-1)
        {
            times++;
            return storage[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int temp= recursive(i,k)+recursive(k+1,j)+1;
            if(min>temp)
            {
                min=temp;
            }
        }
        storage[i][j]=min;
        return min;
    }



}
public class palindrome_partitioning_with_M {



    public static void main(String[] args) {
        p_handler_with_m object=new p_handler_with_m();
        String string;
        Scanner scanner=new Scanner(System.in);
        string=scanner.nextLine();
        object.input(string);
        System.out.println("The Total Minimum Partition to get Palindrome is "+object.recursive(0,string.length()-1));
        System.out.println("Total Call  rejected Because of available result( DP ) : "+object.times);
    }

}
