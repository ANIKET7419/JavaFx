package Comp_P;
import java.util.Scanner;
class Solution {
    public double myPow(double x, int n) {
        if(n==0)
        {
            return 1;
        }
        double temp=myPow(x,n/2);
        if(n%2==0)
        {
            return temp*temp;
        }
        else
        {
            return x*temp*temp;
        }
    }
}
public class Main_1
{
    public static void main(String argc[])
    {
        double x;
        int n;
        Scanner scanner=new Scanner(System.in);
        x=scanner.nextDouble();
        n=scanner.nextInt();
        Solution object=new Solution();
        System.out.println(object.myPow(x,n));
        System.out.println(Math.pow(x,n));

    }
}