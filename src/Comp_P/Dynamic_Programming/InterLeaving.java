package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class InterLeaving_Handler
{
    int counter=0;
    String word1,word2,word3;
    void input(String word1,String word2,String word3)
    {
        this.word1=word1;
        this.word2=word2;
        this.word3=word3;

    }
    boolean isInterLeaving(int index1,int index2,int index3)
    {
        if(index1==word1.length()&&index2==word2.length()&&index3==word3.length())
            return true;
      boolean condition=false;
      if(index1<word1.length())
          if(word1.charAt(index1)==word3.charAt(index3))
          condition=isInterLeaving(index1+1,index2,index3+1);

        boolean condition2=false;
        if(index2<word2.length())
            if(word2.charAt(index2)==word3.charAt(index3))
                condition2=isInterLeaving(index1,index2+1,index3+1);
          return condition || condition2;
    }
}
public class InterLeaving {
    public static void main(String[] args) {
     InterLeaving_Handler handler=new InterLeaving_Handler();
     String word1,word2,word3;
     System.out.println("Enter String 1 ");
     Scanner scanner=new Scanner(System.in);
     word1=scanner.nextLine();
     System.out.println("Enter String 2 ");
     word2=scanner.nextLine();
     System.out.println("Enter String 3 ");
     word3=scanner.nextLine();
     handler.input(word1,word2,word3);
     System.out.println("InterLeaving ???? "+handler.isInterLeaving(0,0,0));
        System.out.println(handler.counter);

    }
}
