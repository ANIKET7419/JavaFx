package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class RegularExpressionHandler
{
    String word,pattern;
    boolean evaluate(int i)
    {
        StringBuilder builder=new StringBuilder(pattern.substring(0,i));
        for (int j=0;j<i;j++)
        {
            if(builder.charAt(j)=='*')
            {
                builder.deleteCharAt(j);
                if(j!=0)
                builder.deleteCharAt(j-1);
            }
        }
        if(builder.length()!=0)
            return false;
        else
            return true;
    }
    void input(String word,String pattern)
    {
        this.pattern=pattern;
        this.word=word;
    }
    boolean isMatched(int i,int j)
    {
        if(i<0||j<0)
            return false;
        if(i==0&&j==0)
        {

            return true;

        }
        else  if (i==0&&j!=0)
            return false;
        else if(j==0&&i!=0)
        {
           return evaluate(i);
        }
        else
        {
            if(pattern.charAt(i-1)!='.'&&pattern.charAt(i-1)!='*') {
                if (pattern.charAt(i - 1) == word.charAt(j - 1))
                {
                    return isMatched(i-1,j-1);
                }
                else
                {
                    return false;
                }
            }
            else if(pattern.charAt(i-1)=='.')
            {
                return isMatched(i-1,j-1);
            }
            else {
                boolean formore=false;
                if(pattern.charAt(i-2)==word.charAt(j-1)&&isMatched(i,j-1))
                {
                    formore=true;
                }
                else if (pattern.charAt(i-2)=='.'&&isMatched(i,j-1))
                    formore=true;
                return  isMatched(i-1,j)||isMatched(i-2,j)|| formore;
            }
        }
    }

}

public class RegularExpression {
    public static void main(String[] args) {
        RegularExpressionHandler handler=new RegularExpressionHandler();
        String word,pattern;
        System.out.println("Enter String word");
        Scanner scanner=new Scanner(System.in);
        word=scanner.nextLine();
        System.out.println("Enter Pattern ");
        pattern=scanner.nextLine();
        handler.input(word,pattern);
        System.out.println("Is Matched "+handler.isMatched(pattern.length(),word.length()));

    }
}
