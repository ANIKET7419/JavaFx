package Comp_P.BruteForce;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class LPScount
{


    String data;
    ArrayList<String> list=new ArrayList<>();
    void input(String data)
    {
        this.data=data;

    }
    boolean ispalindromic(String temp,int i,int j)
    {
        if(i>=j)
            return true;
        else
        {
            if(temp.charAt(i)==temp.charAt(j))
                return ispalindromic(temp,i+1,j-1);
            else
                return false;
        }
    }
    void  lps(String temp,int index)
    {
      if(index==data.length())
      {
          if (!list.contains(temp)&&ispalindromic(temp,0,temp.length()-1))
          list.add(temp);
          return;
      }
      lps(temp+data.charAt(index),index+1);
      lps(temp,index+1);
    }
    int count()
    {
        System.out.println(list);
        return list.size();
    }


}

public class LPSCOUNT {
    public static void main(String[] args) {
      LPScount count=new LPScount();
      System.out.println("Enter String");
      String data;
      Scanner scanner=new Scanner(System.in);
      data=scanner.nextLine();
      count.input(data);
      count.lps("",0);
      System.out.println("The total count is "+(count.count()-1));//because empty string is also considered
    }
}



