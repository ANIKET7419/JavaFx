package Comp_P.Dynamic_Programming.LCS_FORMAT;
//without memoization but we can use memoization
import java.util.Arrays;
import java.util.Scanner;

class LongestCommonStringHandler
{
    String s1,s2;
   // int storage[][];
    int counter=0;
    int max=Integer.MIN_VALUE;
    void input(String s1,String s2)
    {
        this.s1=s1;
        this.s2=s2;
       /* storage=new int[s1.length()+1][s2.length()+1];
        for (int temp[]:storage)
        {
            Arrays.fill(temp,-1);
        }*/
    }
    void lcs(int i,int j)
    {
        if(counter>max)
            max=counter;
        if(i<0||j<0)
            return;

        if(s1.charAt(i)==s2.charAt(j))
        {

            counter=counter+1;
            lcs(i-1,j-1);
        }
        else {
        counter=0;
        lcs(i,j-1);
        lcs(i-1,j);
        }

    }
}
public class LongestCommonSubstring {

    public static void main(String[] args) {
        LongestCommonStringHandler handler=new LongestCommonStringHandler();
        String s1,s2;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String 1");
        s1=scanner.nextLine();
        System.out.println("Enter String 2");
        s2=scanner.nextLine();
        handler.input(s1,s2);
        handler.lcs(s1.length()-1,s2.length()-1);
        System.out.println("The Length is "+handler.max);
    }
}
