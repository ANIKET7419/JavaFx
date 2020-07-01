package Comp_P.Dynamic_Programming;
import java.util.Scanner;
/*

Bit Masking is also used

where we need to choose only one at a time there we can use bit masking it is simple to implement


for example
initial state : 0000000
when we use 0 index value then 1<<j = 1<<0 = 0000001
when we use 1 index value then 1 <<j = 1<<1 = 00000010
to check whether it is usable then do and of current state and previous state
for example if currently we use 1 index then current state is 0000010
   previous is 000110100100
   we do and the result is 0 it means we can use otherwise we can not use
     after using give state to another call  previous state | current state




 */
class CanIWinHandler
{

    private int maximum;
    void input(int maximum)
    {
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
        handler.input(maximumvalue);
        System.out.println("Will I Win ? "+handler.caniwin(0,target));
    }
}
