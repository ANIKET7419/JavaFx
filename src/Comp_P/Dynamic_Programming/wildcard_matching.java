package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class handler
{
    String data;
    String pattern;
    void input(String data,String pattern)
    {
        this.data=data;
        this.pattern=pattern;
    }
    boolean ismatched(int i,int j)
    {
        if(i==0||j==0)
        {
         if(i==0&&j==0)
             return true;
         else
         {
             if (i==0)
                 return false;
             else if (j==0)
             {
                 if(pattern.charAt(i-1)=='*')
                 {
                     return ismatched(i-1,j);
                 }
             }
         }
        }
        if(pattern.charAt(i-1)!='*'&&pattern.charAt(i-1)!='?') {
            if (data.charAt(j-1) == pattern.charAt(i-1)) {
                return ismatched(i - 1, j - 1);
            } else {
                return false;
            }
        }
        else
        {
            if(pattern.charAt(i-1)=='?')
            {
                return ismatched(i - 1, j - 1);
            }
            else
            {
                return ismatched(i - 1, j) || ismatched(i, j - 1);
            }



        }

    }
}
public class wildcard_matching {


    public static void main(String[] args) {
        handler object=new handler();
        String data;
        String pattern;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String");
        data=scanner.nextLine();
        System.out.println("Enter Pattern");
        pattern=scanner.nextLine();
        object.input(data,pattern);
        System.out.println("Valid or Not "+object.ismatched(pattern.length(),data.length()));
    }
}
