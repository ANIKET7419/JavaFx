package Comp_P.Dynamic_Programming;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class WordBreakHandler
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
    boolean isBreakable(int i,int j)
    {
        if (isinList(i,j)) {
            storage[i][j]=1;
            return true;
        }
        if(i>=j) {
            storage[i][j]=0;
            return false;
        }

         if(storage[i][j]!=-1)
             return storage[i][j]==1?true:false;
        boolean result=false;
        for(int k=i;k<j;k++)
        {
        result=result || (isBreakable(i,k) && isBreakable(k+1,j));
        }
        storage[i][j]=result==false?0:1;
        return result;
    }

}

public class WordBreak {
    public static void main(String[] args) {
        WordBreakHandler handler = new WordBreakHandler();
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
