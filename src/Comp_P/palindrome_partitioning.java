package Comp_P;
import java.util.Scanner;

class  p_handler
{
    String string;

    void input(String string)
    {
        this.string=string;
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
            return 0;
        }
        if(ispalindrome(i,j))
        {
            return 0;
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


        return min;
    }



}

public class palindrome_partitioning {

    public static void main(String[] args) {
        p_handler object=new p_handler();
        String string;
        Scanner scanner=new Scanner(System.in);
        string=scanner.nextLine();
        object.input(string);
        System.out.println("The Total Minimum Partition to get Palindrome is "+object.recursive(0,string.length()-1));
    }



}
