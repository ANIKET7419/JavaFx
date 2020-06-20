package Comp_P.Dynamic_Programming.LCS_FORMAT;
import java.util.Arrays;
import java.util.Scanner;

class LCSHandler
{
    String s1,s2;
    int storage[][];
    void input(String s1,String s2)
    {
        this.s1=s1;
        this.s2=s2;
        storage=new int[s1.length()+1][s2.length()+1];
        for (int temp[]:storage)
        {
            Arrays.fill(temp,-1);
        }
    }
    int lcs(int i,int j)
    {
        if(i==0||j==0)
            return 0;
        if(storage[i][j]!=-1)
            return storage[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1))
        {

        storage[i][j]= lcs(i-1,j-1)+1;
        return storage[i][j];
        }
        else
        {
            storage[i][j]= Math.max(lcs(i-1,j),lcs(i,j-1));
            return storage[i][j];
        }
    }

}
public class LongestCommonSubsequence {

    public static void main(String[] args) {
     LCSHandler handler=new LCSHandler();
     String s1,s2;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String 1");
        s1=scanner.nextLine();
        System.out.println("Enter String 2");
        s2=scanner.nextLine();
        handler.input(s1,s2);
        System.out.println("The Longest Common Subsequence Length is "+handler.lcs(s1.length(),s2.length()));

    }
}
