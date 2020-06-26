package Comp_P.Dynamic_Programming;

//Under Progress
import java.util.Scanner;

class MaximumProductSubarrayHandler
{
    int data[];
    void input(int data[])
    {
        this.data=data;
    }
    int maximumProduct()
    {

        int dp[]=new int[data.length];
        dp[0]=data[0];
        for (int i=1;i<data.length;i++)
        {
            if (data[i]*dp[i-1]>data[i])
            {
                dp[i]=data[i]*dp[i-1];
            }
            else
                dp[i]=data[i];
        }
        int max=Integer.MIN_VALUE;
        for (int i=0;i<data.length;i++)
        {
            if (max<dp[i])
            {
                max=dp[i];
            }
        }
        return max;
    }

}
public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarrayHandler handler=new MaximumProductSubarrayHandler();
        System.out.println("Enter Data Length");
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int data[]=new int[n];
        System.out.println("Enter Data");
        for (int i=0;i<n;i++)
        {
            data[i]=scanner.nextInt();
        }
        handler.input(data);
        System.out.println("The Result is "+handler.maximumProduct());
    }
}
