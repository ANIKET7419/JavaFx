package Comp_P.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;
//Under Process
class CanIWinHandler
{
    int maximum;
    boolean istraversed[];
    byte[] caniwin(int i,int j,byte turn,int target)
    {
        byte[]result=new byte[]{0,1};
        if (i>j)
            return new byte[]{turn,0};
        else if (target<=maximum&&!(istraversed[maximum]))
            return new byte[]{turn,1};
        else {


            for (int k=i;k<=j;k++)
            {
                istraversed[k]=true;
                byte first[],second[];
                if (turn==1) {
                    first=caniwin(i, k-1, (byte) 0,target-k );
                    second=caniwin(k+1,j,(byte)0,target-k);
                }
                else {
                    first=caniwin(i, k-1, (byte) 1,target-k );
                    second=caniwin(k+1,j,(byte)1,target-k);
                }
                istraversed[k]=false;
                if ((first[0]==1&&first[1]==1)&&(second[0]==1&&second[1]==1))
                {
                    result[0]=1;
                    result[1]=1;
                }
            }
            return result;
        }

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
        handler.maximum=maximumvalue;
        handler.istraversed=new boolean[maximumvalue+1];
        Arrays.fill(handler.istraversed,false);
        byte []result=handler.caniwin(1,maximumvalue,(byte)1,target);
        if (result[0]==1&&result[1]==1)
        {
            System.out.println("I will Win");
        }
        else System.out.println("I Will not Win");
    }
}
