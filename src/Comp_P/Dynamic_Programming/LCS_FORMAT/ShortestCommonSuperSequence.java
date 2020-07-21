package Comp_P.Dynamic_Programming.LCS_FORMAT;


import java.util.ArrayList;

public class ShortestCommonSuperSequence {
    String s1,s2;
    ArrayList<int[]>storage[][];
    int counter=0;
    void input(String s1,String s2)
    {
        this.s1=s1;
        this.s2=s2;
        storage=new ArrayList[s1.length()][s2.length()];
    }
    ArrayList<int[]> lcs(int i,int j)
    {
        if(i>=s1.length()||j>=s2.length())
            return new ArrayList();

        if(storage[i][j]!=null)
        {
            counter++;
            return storage[i][j];
        }
        if (s1.charAt(i)==s2.charAt(j))
        {

            int ind[]=new int[]{i,j};
            ArrayList <int[]>l=new ArrayList<>();
            l.add(ind);
            l.addAll(lcs(i+1,j+1));
            return storage[i][j]=l;
        }

        else
        {
            ArrayList<int[]> temp1=lcs(i+1,j);
            ArrayList<int[]> temp2=lcs(i,j+1);
            if (temp1.size()>temp2.size())
                return storage[i][j]=temp1;
            else
                return storage[i][j]=temp2;
        }
    }
}



class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        ShortestCommonSuperSequence handler=new ShortestCommonSuperSequence();
        handler.input(str1,str2);
        ArrayList<int[]> result=handler.lcs(0,0);
        String actualresult="";
        for(int i=0;i<result.size();i++)
        {
            int temp[]=result.get(i);
            if(i>=1)
            {

                int prev[]=result.get(i-1);
                actualresult+=str1.substring(prev[0]+1,temp[0]);
                actualresult+=str2.substring(prev[1]+1,temp[1]);
                actualresult+=str1.charAt(temp[0]);
            }
            else
            {
                actualresult+=str1.substring(0,temp[0]);
                actualresult+=str2.substring(0,temp[1]);
                actualresult+=str1.charAt(temp[0]);
            }
        }
        int y[]=result.get(result.size()-1);
        actualresult+=str1.substring(y[0]+1,str1.length());
        actualresult+=str2.substring(y[1]+1,str2.length());
        System.out.println(handler.counter);
        return actualresult;
    }

}