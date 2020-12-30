package Comp_P;

import java.util.ArrayList;
import java.util.Scanner;

public class BasicCalculator {


    static boolean isOperand(char a)
    {
        return !(a=='+'||a=='-'||a=='/'||a=='*'||a=='('||a==')');
    }

    public static ArrayList<String> split(String exp)
    {
     ArrayList<String> list=new ArrayList<>();


     for(int i=0;i<exp.length();)

     {
         if (isOperand(exp.charAt(i)))
         {
             String temp="";
             while(i<exp.length()&&isOperand(exp.charAt(i)))
             {
                 if (exp.charAt(i)!=' ')
                 temp+=exp.charAt(i);
                 i++;
             }
             list.add(temp);
         }
         else if (exp.charAt(i)!=' ')
         {
             list.add(""+exp.charAt(i));
             i++;
         }
     }



     return list;
    }


    public static  ArrayList<String> converToPostfix(ArrayList<String> exp)
    {
     ArrayList<String> postfix=new ArrayList<>();






        return postfix;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Expression ");
        String exp=scanner.nextLine();
        ArrayList<String> list=split(exp);
        ArrayList<String> postfix=converToPostfix(list);
    }

}
