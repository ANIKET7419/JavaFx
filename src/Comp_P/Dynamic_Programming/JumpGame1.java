package Comp_P.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

class JumpGame1Handler
{
    int data[];
    void input(int data[])
    {
        this.data=data;
    }
    boolean isreachable()
    {
        boolean dp[]=new boolean[data.length];
        Arrays.fill(dp,false);
        dp[0]=true;
        for (int i=1;i<data.length;i++)
        {
            for (int j=i-1;j>=0;j--)
            {
                if(data[j]+j>=i&&dp[j])
                {
                    dp[i]=true;
                    break;
                }

            }
        }

        return dp[data.length-1];
    }
}
public class JumpGame1 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        JumpGame1Handler handler=new JumpGame1Handler();
        int []data;
        System.out.println("Enter Length of the data");
        int n=scanner.nextInt();
        data=new int[n];
        System.out.println("Enter Data");
        for (int i=0;i<n;i++)
        {
            data[i]=scanner.nextInt();
        }
        handler.input(data);
        if(data[0]==0&&data.length>1) {
            System.out.println("Unreachable");
            System.exit(100);
        }
        boolean result=handler.isreachable();
        System.out.println("Reachable or not  "+result);


    }
}
