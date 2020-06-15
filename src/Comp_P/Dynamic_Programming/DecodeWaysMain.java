package Comp_P.Dynamic_Programming;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

class DecodeWays
{
    int totalWays(@NotNull String data )
    {
        int total=0;
        if(data.length()==0)
            return 0;
        else if(data.length()==1&&Integer.parseInt(data)>0)
            return 1;
        else if (data.length()==1&&Integer.parseInt(data)==0)
        {
            return 0;
        }
        else
        {
            if(data.length()!=2) {
                Integer k = Integer.parseInt(data.substring(0, 1));
                if (k > 0 && k < 27) {
                    total = totalWays(data.substring(1, data.length() - 1) + totalWays(data.substring(2, data.length() - 1)));
                } else {
                    total = totalWays(data.substring(1, data.length() - 1));
                }
            }
            else
            {
                Integer k = Integer.parseInt(data.substring(0, 1));
                if (k >= 10 && k < 27) {
                    return 2;
                } else {

                }
            }
        }
        return total;
    }
}
public class DecodeWaysMain {

    public static void main(String[] args) {
        DecodeWays decodeWays=new DecodeWays();
        String data;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String");
        data=scanner.nextLine();
        System.out.println("The total Ways are "+decodeWays.totalWays(data));
    }
}
