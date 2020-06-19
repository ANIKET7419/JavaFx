package Comp_P.BruteForce;
/*
* Longest/shortest _____  Subsequence Format Based Questions With Brute Force Approach
*
*
* In this problem we take if it satisfy the constraint
* we don't take whether it satisfy constraint or not
* Format For Longest ->
*
* int lps(int index)
    {
        if(index==data.length())
            return 0;
        int taken=0;
        int nontaken=0;

        return Math.max(taken,nontaken);
    }
*  Format For Shortest ->
*
* int lps(int index)
    {
        if(index==data.length())
            return 0;
        int taken=0;
        int nontaken=0;

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
            return 0;
        int taken=0;
        if(ispalindromic(temp+data.charAt(index),0,temp.length()))
            taken=lps(temp+data.charAt(index),index+1);
        int nontaken=lps(temp,index+1);

        return Math.max(taken,nontaken);
    }
}
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {

    }
}
