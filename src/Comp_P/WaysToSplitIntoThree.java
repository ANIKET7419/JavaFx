package Comp_P;
import java.util.Scanner;
public class WaysToSplitIntoThree {



    public static int ways(int index,int count,int input[],int sum,int prefix[])
    {
        if (count==1) {

            if(sum<=prefix[input.length-1]-prefix[index-1])
                return 1;
            else
                return 0;

        }
        if (count==3)
        {
            int result=0;
                for (int j=0;j<input.length-2;j++)
                   result+=ways(j+1,count-1,input,prefix[j],prefix);
            return result;
        }
        if (count==2)
        {
            int result=0;
                for (int j=index;j<input.length-1;j++)
                {
                    if (prefix[j]-prefix[index-1]>=sum)
                    result+=ways(j+1,count-1,input,prefix[j]-prefix[index-1],prefix);
                }

            return result;
        }
    return 0;

    }



    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        System.out.println("Enter array size");
        n=scanner.nextInt();
        System.out.println("Enter data");
        int input[]=new int[n];
        for (int i=0;i<n;i++)
            input[i]=scanner.nextInt();
        int prefix[]=new int[n];
        prefix[0]=input[0];
        for (int i=1;i<n;i++)
            prefix[i]=prefix[i-1]+input[i];
        System.out.println("Number of ways "+ways(0,3,input,0,prefix));

    }


}
