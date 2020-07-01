package Comp_P.Dynamic_Programming;

import com.sun.prism.shader.DrawEllipse_LinearGradient_REFLECT_AlphaTest_Loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class CanIWinHandler
{

    int target,maximum;
    void input(int target,int maximum)
    {
        this.target=target;
        this.maximum=maximum;
    }
    boolean caniwin(int  state,int target)
    {
        boolean result1=false;
        for (int i=0;i<maximum;i++)
        {
            int currentstate=1<<i;
            int result=currentstate & state;
            if (result==0)
            {
                if (target<=i+1)
                    return true;
               boolean temp=caniwin(currentstate|state,target-(i+1));
               if (!temp)
               {
                   result1=true;
               }
            }
        }
        return result1;

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
        System.out.println("Will I Win ? "+handler.caniwin(0,target));
    }
}
