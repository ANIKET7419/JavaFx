package Comp_P.Dynamic_Programming;
import java.util.Scanner;

public class LongestValidParenthesis {


    public static int [] lValidP(String data)
    {
        int dp[]=new int[data.length()];
        dp[0]=0;
        for(int i=1;i<data.length();i++)
        {
            if (data.charAt(i)==')')
            {
                if (data.charAt(i-1)=='(')
                {
                    if (i>=2)
                        dp[i]=dp[i-2]+2;
                    else
                        dp[i]=2;
                }
                else
                {
                    if (i-dp[i-1]-1>=0) {
                        if (data.charAt(i - dp[i - 1] - 1) == '(') {
                            if (i - dp[i - 1] - 2 >= 0)
                                dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                            else
                                dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
            }
        }

        int result=0;
        int index=-1;
        for(int i=0;i<data.length();i++)
        {
            if (result<dp[i]) {
                result = dp[i];
                index=i;
            }
        }
        return new int[]{result,index};
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String data=scanner.next();
        int result[]=lValidP(data);
        System.out.println("Longest Valid P length is "+result[0]);
        if (result[1]!=-1)
        {
            for(int j=result[1]-result[0]+1;j<=result[1];j++)
                System.out.print(data.charAt(j));
            System.out.println();
        }
    }




}
