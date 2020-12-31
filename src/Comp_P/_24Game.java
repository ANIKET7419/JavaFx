package Comp_P;
import java.util.Scanner;

public class _24Game {
    static char operator[]={'+','-','/','*'};
    public static  boolean solve(double cards[])
    {

        if (cards.length==1)
        {
            return Math.abs(cards[0]-24)<0.0000001;
        }
        for (int i=0;i<cards.length;i++)
        {
            for(int j=i+1;j<cards.length;j++)
            {
                double temp[]=new double[cards.length-1];
                int w=0;
                for (int k=0;k<cards.length;k++)
                {
                    if (k!=i&&k!=j)
                    {
                        temp[w++]=cards[k];
                    }
                }
                for(char op:operator) {
                    if (op=='+') {
                        temp[temp.length-1]=cards[i]+cards[j];
                    }
                    else if (op=='-') {
                        temp[temp.length-1]=cards[i]-cards[j];
                    }
                    else if (op=='*') {
                        temp[temp.length-1]=cards[i]*cards[j];
                    }
                    if(solve(temp))
                        return true;
                    if (op=='-')
                    {

                        temp[temp.length-1]=cards[j]-cards[i];
                        if(solve(temp))
                            return true;
                    }
                    if (op=='/')
                    {
                        if (cards[j]!=0) {
                            temp[temp.length-1]=cards[i]/cards[j];
                            if (solve(temp))
                                return true;
                        }
                        if (cards[i]!=0)
                        {
                            temp[temp.length-1]=cards[j]/cards[i];
                            if (solve(temp))
                                return true;
                        }
                    }

                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Enter the card values from 1 to 9 ");
        Scanner scanner=new Scanner(System.in);
        double cards[]=new double[4];
        for (int i=0;i<4;i++)
            cards[i]=scanner.nextDouble();
       System.out.println("Is possible ? " +solve(cards));

    }
}
