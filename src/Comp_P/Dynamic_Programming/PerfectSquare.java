
/*





Under Processing wrong till then



 */







package Comp_P.Dynamic_Programming;


import com.sun.webkit.dom.XPathResultImpl;

import javax.swing.*;
import java.util.Scanner;

class PerfectSquareHandler
{
    int n;
    void input(int n)
    {
        this.n=n;
    }
    int  perfectsquare(int k)
    {
        if (k==0||k==1)
            return 0;
        int counter=Integer.MAX_VALUE;
        if (k==n)
        for (int l=k-1;l>=1;l--)
        {
            double root=Math.sqrt(l);
            if (root==((int)root)) {
                int temp=perfectsquare(k-l);
                if (counter<temp+1)
                {
                    counter=temp+1;
                }
            }
        }
        else{
            for (int l=k;l>=0;l--)
            {
                double root=Math.sqrt(l);
                if (root==((int)root)) {
                    int temp=perfectsquare(k-l);
                    if (counter<temp+1)
                    {
                        counter=temp+1;
                    }
                }
            }
        }
        return counter==Integer.MAX_VALUE?0:counter;
    }

}
public class PerfectSquare {
    public static void main(String[] args) {
        PerfectSquareHandler handler =new PerfectSquareHandler();
        int n;
        System.out.println("Enter Number");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        handler.input(n);

        System.out.println("The Result is "+handler.perfectsquare(n));
    }
}
