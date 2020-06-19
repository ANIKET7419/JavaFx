package Comp_P.BruteForce;
/*
* Longest/shortest _____  Subsequence Format Based Questions With Brute Force Approach
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
    int lps(int index)
    {
        if(index==data.length())
            return 0;
        int taken=0;
        int nontaken=0;

        return Math.max(taken,nontaken);
    }
}
public class LongestPalindromicSubsequence {
}
