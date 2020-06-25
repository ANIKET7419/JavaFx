
/*





Under Processing wrong till then



 */







package Comp_P.Dynamic_Programming;


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
        if (k<=0)
            return 0;
        if (k==1)
            return 1;
        if (k==2)
            return 2;
        if (k==3)
            return 0;
        int counter=Integer.MAX_VALUE;
        int end;
        if ((k-1)%2==0)
            end=(k-1)/2;
        else
            end=((k-1)/2)+1;
        for (int l=k-1;l>=end;l--)
        {
            double root=Math.sqrt(l);
            double root1=Math.sqrt(k-l);
            if (root==((int)root))
            {

               int temp= perfectsquare(k-l+1);
               if (temp>=1)
               {
                if (temp+1<counter){
                    counter=temp+1;
                }

               }
            }
            else if (root1==((int)root1)&&root1!=1)
            {
                int temp= perfectsquare(l+1);
                if (temp>=1)
                {
                    if (temp+1<counter){
                        counter=temp+1;
                    }

                }
            }
            else if (root1==((int)root1)&&root1==1)
                counter++;
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
