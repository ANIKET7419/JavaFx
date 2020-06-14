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
        if(i<0||j<0)
            return false;
        if(pattern.charAt(j)!='*'&&pattern.charAt(j)!='?') {
            if (data.charAt(i) == pattern.charAt(j)) {
                return ismatched(i - 1, j - 1);
            } else {
                return false;
            }
        }
        else
        {
            if(pattern.charAt(j)=='?')
            {
                return ismatched(i - 1, j - 1);
            }
            else
            {
                return true&&ismatched(i-1,j-1);
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
        System.out.println("Valid or Not "+object.ismatched(data.length()-1,pattern.length()-1));
    }
}
