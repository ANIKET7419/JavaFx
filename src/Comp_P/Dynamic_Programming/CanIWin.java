package Comp_P.Dynamic_Programming;

import com.sun.prism.shader.DrawEllipse_LinearGradient_REFLECT_AlphaTest_Loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class CanIWinHandler
{
    byte complement(byte value)
    {
        if(value==0)
            return 1;
        else return 0;
    }
    byte caniwin(int i,int j,int target)
    {
        System.out.println(i+" "+j);
        byte  result=0;
        if (i>j)
            return -1;
        else if (i==j)
        {
            if (target<=i)
                return 1;
            else
                return 0;
        }
        else
        {

            int sum=0;
            for (int k=i;k<=j;k++)
                sum+=k;
            if (sum<target)
                return 0;

            for (int k=i;k<=j;k++)
            {
                if (target-k<=0)
                {
                    return 1;
                }
                else {
                    byte temp1 = caniwin(i, k - 1, target - k);
                    byte temp2 = caniwin(k + 1, j, target - k);
                    if (temp1 != -1 && temp2 != -1) {
                        if (temp1 == 0 && temp2 == 0) {
                            result = 1;

                        }
                    } else if (temp1 == -1) {
                        if (temp2 == 0) {
                            result = 1;

                        }
                    } else {
                        if (temp1 == 0) {
                            result = 1;

                        }
                    }
                }
            }

        }
        return result;
    }
}

public class CanIWin {
    public static void main(String[] args) {
        CanIWinHandler handler=new CanIWinHandler();
        int maximumvalue;
        int target;
        System.out.println("Enter Target ");
        Scanner scanner=new Scanner(System.in);
        target=scanner.nextInt();
        System.out.println("Enter Maximum Value");
        maximumvalue=scanner.nextInt();
        System.out.println("Will I Win ? "+(handler.caniwin(1,maximumvalue,target)==1?true:false));
    }
}
