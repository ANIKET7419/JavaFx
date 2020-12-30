package Comp_P;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

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

     static int getPrecedence(char op)
     {
       if (op=='/'||op=='*')
           return 1;
       else
           return 2;


     }
    public static  ArrayList<String> convertToPostfix(ArrayList<String> exp)
    {
        ArrayList<String> postfix=new ArrayList<>();
        Stack<String> stack=new Stack<>();
        for(String te:exp)
        {
            if (isOperand(te.charAt(0)))
                postfix.add(te);
            else if (te.charAt(0)=='(')
            {
                stack.push("(");
            }
            else if (te.charAt(0)==')')
            {
                while(!stack.peek().equals("("))
                    postfix.add(stack.pop());
                stack.pop();
            }
            else
            {
                if (stack.size()>=1)
                {
                    int t1=getPrecedence(te.charAt(0));
                    int t2=getPrecedence(stack.peek().charAt(0));
                    if (t1>t2)
                        stack.push(te);
                    else
                    {
                        while(stack.size()>=1&&t1<=getPrecedence(stack.peek().charAt(0)))
                        {
                            postfix.add(stack.pop());
                        }
                        stack.add(te);
                    }
                }
                else
                    stack.push(te);
            }
        }
        while(!stack.isEmpty())
            postfix.add(stack.pop());

        return postfix;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Expression ");
        String exp=scanner.nextLine();
        ArrayList<String> list=split(exp);
        ArrayList<String> postfix=convertToPostfix(list);
        System.out.println(postfix);
    }

}
