package Comp_P.Dynamic_Programming.LCS_FORMAT;

import java.util.Arrays;
import java.util.Scanner;
class LPScount
{


    String data;
    int storage[];
    void input(String data)
    {
        this.data=data;
        storage=new int[data.length()];
    }
    int lps()
    {

        storage[0]=1;
      for (int i=1;i<data.length();i++)
      {
          if(data.charAt(i)!=data.charAt(0))
              storage[i]=storage[i-1]+1;
          else
          {
              storage[i]=storage[i-1]+1;
          }
      }

        return 0;
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



