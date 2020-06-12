package Comp_P;

import java.util.Scanner;

class longest_palindrome_handler
{
    int storage[][];
    String data;
    int hit=0;
    void input(String data)
    {
        this.data=data;
        storage=new int[data.length()][data.length()];
        for(int i=0;i<data.length();i++)
        {
            for (int j=0;j<data.length();j++)
            {
                storage[i][j]=-1;
            }
        }
    }
    boolean ispalindrome(int i,int j)
    {
        if(i>=j)
        {
            return true;
        }
        else {
            if (data.charAt(i) == data.charAt(j)) {
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
            storage[i][j]=1;
            return 1;
        }
        if(storage[i][j]!=-1) {

            hit++;
            return storage[i][j];
        }
        if(ispalindrome(i,j))
        {
            storage[i][j]=j-i+1;
            return j-i+1;
        }
        int max=Integer.MIN_VALUE;
        for(int k=i;k<j;k++)
        {
            int temp1=recursive(i,k);
            int temp2=recursive(k+1,j);
            if(temp1>temp2)
            {
                if(max<temp1)
                {
                    max=temp1;
                }
            }
            else
            {
                if(temp2>max)
                {
                    max=temp2;
                }
            }
        }
        storage[i][j]=max;
     return max;

    }


}
public class longest_palindrome {
    public static void main(String[] args) {
        longest_palindrome_handler object=new longest_palindrome_handler();
        String data;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String");
        data=scanner.nextLine();
        object.input(data);
        System.out.println("The Longest Palindrome length is  "+object.recursive(0,data.length()-1));
        System.out.println("Total Recomputation Needed But not happened " +object.hit);
    }


}
