package Comp_P.BruteForce;
import java.util.Scanner;

/*
* Longest/shortest _____  Subsequence Format Based Questions With Brute Force Approach
* Format For Longest ->
*
* int lps(int index)
    {
        if(index==data.length())
            {
            *
            * //check whether statisfy constraint or not if yes return length otherwise 0
            *
             }
        int taken=lps(--);
        int nontaken=lps(--);

        return Math.max(taken,nontaken);
    }
*  Format For Shortest ->
*
* int lps(int index)
    {
        if(index==data.length())
            {
            *
            * //check whether statisfy constraint or not if yes return length otherwise 0
            *
             }
        int taken=lps(--);
        int nontaken=lps(--);

        return Math.min(taken,nontaken);
    }
*
* */
class LPSHandler
{
    String data;
    void input(String data)
    {
        this.data=data;
    }
    boolean ispalindromic(String temp,int i,int j)
    {
        if(i>=j)
            return true;
        if(temp.charAt(i)==temp.charAt(j))
            return ispalindromic(temp,i+1,j-1);
        else
            return false;

    }
    int lps(String temp,int index)
    {
        if(index==data.length())
        {
            if (ispalindromic(temp,0,temp.length()-1))
             return temp.length();
            else
                return 0;

        }
        int taken=lps(temp+data.charAt(index),index+1);
        int nontaken=lps(temp,index+1);
        return Math.max(taken,nontaken);
    }
}
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
       LPSHandler handler=new LPSHandler();
       String data;
       System.out.println("Enter Data");
      Scanner scanner=new Scanner(System.in);
      data=scanner.nextLine();
        handler.input(data);

        System.out.println("The Maximum Palindromic Length is "+handler.lps("",0));
    }
}
