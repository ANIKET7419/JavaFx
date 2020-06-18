package Comp_P.Dynamic_Programming;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WordBreak2Handler
{
    String data=null;
    List<String> dict=null;
    int storage[][];
    void input(@NotNull String data, @NotNull List<String> dict)
    {
        this.data=data;
        this.dict=dict;
        storage=new int[data.length()][data.length()];
        for (int i=0;i<data.length();i++)
        {
            for (int j=0;j<data.length();j++)
            {
                storage[i][j]=-1;
            }
        }
    }
    boolean isinList(int i,int j)
    {

        if(dict.contains(data.substring(i,j+1)))
            return true;
        else
            return false;
    }
    List<String>isBreakable(int i,int j)
    {
        List<String> result=new ArrayList<String>();
        if (isinList(i,j)) {
            result.add(data.substring(i,j+1));
            return result;
        }
        if(i>=j) {
            return null;
        }
        for(int k=i;k<j;k++)
        {
            List <String>left=isBreakable(i,k);
            List<String> right=isBreakable(k+1,j);
            if( left!=null&&right!=null)
            {
              String temp="";
              for(String t:left)
              {
                  temp+=" "+t;
              }
              for (String t:right)
              {
                  temp+=" "+t;
              }
              result.add(temp);
            }
        }
        return result.size()==0?null:result;
    }
}
public class WordBreak2 {


    public static void main(String[] args) {
        WordBreak2Handler handler = new WordBreak2Handler();
        String data;
        List<String> dict = new ArrayList<String>();
        System.out.println("Enter Dictionary Size");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println("Enter Dictionary Data");
        for (int i=0;i<n;i++)
        {
            String temp=scanner.nextLine();
            dict.add(temp);
        }
        System.out.println("Enter Word");
        data=scanner.nextLine();
        handler.input(data,dict);
        System.out.println("Result :-> "+handler.isBreakable(0,data.length()-1) );

    }
}
