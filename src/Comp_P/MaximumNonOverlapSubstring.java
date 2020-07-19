package Comp_P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Under Process
public class MaximumNonOverlapSubstring {

    String s;
    int start[],end[];
    void input(String s)
    {
        this.s=s;
        start=new int[26];
        end=new int[26];
        Arrays.fill(start,Integer.MAX_VALUE);
        Arrays.fill(end,Integer.MIN_VALUE);
        for (int i=0;i<s.length();i++)
        {
            start[s.charAt(i)-'a']=Math.min(start[s.charAt(i)-'a'],i);
            end[s.charAt(i)-'a']=Math.max(end[s.charAt(i)-'a'],i);
        }
    }
    List<String> Mcm(int i,int j)
    {
        List<String>  result=new ArrayList<>();
        if(i>j)
            return result;
        if (i==j)
        {
            result.add(""+s.charAt(i));
            return result;
        }
        int max=Integer.MIN_VALUE;
        for (int k=i;k<=j;k++)
        {
            List<String> temp1=Mcm(i,start[s.charAt(k)]-1);
            List<String> temp2= Mcm(end[s.charAt(k)]+1,j);
           if (max<temp1.size()+temp2.size())
           {

               max=temp1.size()+temp2.size();
               result.clear();
               result.add(s.substring(start[s.charAt(k)-'a'],end[s.charAt(k)-'a']+1));
               result.addAll(temp1);
               result.addAll(temp2);
           }
        }



        return result;
    }










}
