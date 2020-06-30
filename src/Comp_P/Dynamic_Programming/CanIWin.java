package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class CanIWinHandler
{
    byte[] caniwin(int i,int j,byte turn,int target)
    {
        byte[]result=new byte[]{0,1};
        if (i>j)
            return new byte[]{turn,0};
        else if (i==j)
        {
            if (target<=i)
                return new byte[]{turn,1};
            else
                return new byte[]{turn,0};
        }
        else {


            for (int k=i;k<=j;k++)
            {
                byte first[],second[];
                if (turn==1) {
                    first=caniwin(i, k-1, (byte) 0,target-k );
                    second=caniwin(k+1,j,(byte)0,target-k);
                }
                else {
                    first=caniwin(i, k-1, (byte) 1,target-k );
                    second=caniwin(k+1,j,(byte)1,target-k);
                }
                if ((first[0]==1&&first[1]==1)||(second[0]==1&&second[1]==1))
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
        byte []result=handler.caniwin(1,maximumvalue,(byte)1,target);
        if (result[0]==1&&result[1]==1)
        {
            System.out.println("I will Win");
        }
        else System.out.println("I Will not Win");
    }
}
