package Comp_P;

import java.util.ArrayList;
import java.util.Scanner;

public class _24Game {
    static ArrayList <Integer>cards;
    static char operator[]={'+','-','/','*'};
    public static  boolean solve()
    {
        for (int i=0;i<4;i++)
        {
            for(int j=i;j<4;j++)
            {
                int a=cards.get(i);
                int b=cards.get(j);
                cards.remove(i);
                cards.remove(j);
                for(char op:operator) {
                    if (op=='+')
                        cards.add(a+b);
                    else if (op=='-')
                        cards.add(a-b);
                    else if (op=='*')
                        cards.add(a*b);
                    else
                        cards.add(a/b);
                    solve();
                    cards.remove(cards.size()-1);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
         cards=new ArrayList<>();
        System.out.println("Enter the card values from 1 to 9 ");
        Scanner scanner=new Scanner(System.in);
        for (int i=0;i<4;i++)
            cards.add(scanner.nextInt());
        solve();

    }
}
