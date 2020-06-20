package Comp_P.Dynamic_Programming.LCS_FORMAT;

import java.util.Arrays;
import java.util.Scanner;
class LPScount
{


    String data;
    int storage[][];
    void input(String data)
    {
        this.data=data;
        storage=new int[data.length()][data.length()];
        for (int k[]:storage)
        {
            Arrays.fill(k,-1);
        }
    }
    int lps(int i,int j)
    {

        if(i>j)
            return 0;
        if(i==j)
        {
            storage[i][j]=1;
            return 1;
        }
        if (storage[i][j]!=-1)
            return storage[i][j];
        if(data.charAt(i)==data.charAt(j))
        {
            storage[i][j]=lps(i+1,j-1)+2;
            return storage[i][j];
        }
        else
        {
            storage[i][j]=  Math.max(lps(i+1,j),lps(i,j-1));
            return storage[i][j];
        }
    }


}

public class LPSCOUNT {
    public static void main(String[] args) {
        LPSHandler handler=new LPSHandler();
        String data;
        System.out.println("Enter Data");
        Scanner scanner=new Scanner(System.in);
        data=scanner.nextLine();
        handler.input(data);
        System.out.println("The Maximum Palindromic Length is "+handler.lps(0,data.length()-1));
    }
}



