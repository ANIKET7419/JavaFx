package Comp_P;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class ZUMAGAME {



    public static  int dfs(String hand,String board)
    {
     if (board.length()==0)
         return 0;
     if (hand.length()==0)
     {
         char ch=board.charAt(0);
         for (int i=1;i<board.length();i++)
         {
             if (ch!=board.charAt(i))
                 return -1;
         }
         if (board.length()>=3)
             return 0;
         else
             return -1;
     }
     if (board.length()==1)
     {

         int count=0;
         for (int i=0;i<hand.length();i++)
             if (hand.charAt(i)==board.charAt(0))
                 count++;
             if (count>=2)
                 return 2;
             else
                 return -1;
     }
     int result=Integer.MAX_VALUE;
     char search=board.charAt(0);
     String temp=search+"";
     for (int i=1;i<board.length();i++)
     {
         if (board.charAt(i)==search)
             temp+=search;
         else
         {
             if (temp.length()==1||temp.length()==2)
             {
                 int index=hand.indexOf(search);
                 int temp_res=dfs(hand.substring(0,index)+hand.substring(index+1),board.substring(0,i-temp.length())+board.substring(i));
                 if (temp_res==-1)
                     return -1;
                 if (temp.length()==2)
                 result=Math.min(result,1+temp_res);
                 else
                     result=Math.min(result,2+temp_res);
             }
             else if (temp.length()>2)
             {
                 int temp_res=dfs(hand,board.substring(0,i-temp.length())+board.substring(i));
                 if (temp_res==-1)
                     return -1;
                 result=Math.min(result,temp_res);
             }
             temp=""+board.charAt(i);
             search=board.charAt(i);
         }
     }

        return result;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the value of board ");
        String board=scanner.next();
        System.out.println("Enter the value of hand ");
        String hand=scanner.next();
        System.out.println("Minimum balls required : "+dfs(hand,board));

    }
}
