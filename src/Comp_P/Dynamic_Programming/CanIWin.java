package Comp_P.Dynamic_Programming;

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
    byte[] caniwin(int i,int j,byte turn,int target)
    {
        byte[]result=new byte[2];
        if (i>j)
            return new byte[]{turn,0};
        else {
            boolean flag=false;
            for (int k=i;k<=j;k++)
            {
                if(k>=target)
                {
                    flag=true;
                    result[0]=turn;
                    result[1]=1;
                    break;
                }
            }
            if (!flag)
            {
                int difference;
                int seperator=-1;
                for (int k=i;k<=j;k++)
                {
                    difference=target-k;
                    boolean flag1=false;
                    for (int n=k+1;n<=j;n++)
                    {
                        if (difference<=n)
                        {
                            flag1=true;
                            break;
                        }

                    }
                    if (flag1==false)
                    {
                        System.out.println(difference + " "+target+ " "+k);
                        seperator=k;
                        break;
                    }
                }

                if (seperator!=-1)
                {

                    byte first[]=caniwin(i,seperator-1,complement(turn),target-seperator);
                    byte second[]=caniwin(seperator+1,j,complement(turn),target-seperator);
                    if (first[1]==1||second[1]==1) {
                        result[0] = turn;
                        result[1] = 1;
                    }
                    else
                    {
                        result[0]=turn;
                        result[1]=0;
                    }

                }
                else
                {
                    result[0]=turn;
                    result[1]=0;
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
        else
            System.out.println("I Will not Win");
    }
}
