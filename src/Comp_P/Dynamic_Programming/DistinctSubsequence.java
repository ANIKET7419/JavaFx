package Comp_P.Dynamic_Programming;
import java.util.Arrays;
import java.util.Scanner;
/*

Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It's guaranteed the answer fits on a 32-bit signed integer.


Answer ->


     s1=bbb
     s2=bb
     1. agar s2 ka b s1 ke b se fix hota hai to remaining b of s2 have options for 2 after that if we fix s2 first b with second b of s1 then s2 have option only one
      so the answer is 1+2=3
       Main point it is only if there is continuity in s2 string

       s1=bbbab
       s2=bab
    2. otherwise option is
     ignore karo current character of s1+ ignore karo current character of s2

 */
class DistinctSubsequenceHandler
{

    String s1,s2;
    int storage[][];
    int counter=0;
    void input(String s1,String s2){
        this.s1=s1;
        this.s2=s2;
        storage=new int[s2.length()+1][s1.length()+1];
        for (int temp[]:storage)
        {
            Arrays.fill(temp,-1);
        }
    }
    int compute(int i,int j)
    {
        if (i==0||j==0)
        {
            if(i==0)
                return 1;
            if (i!=0&&j==0)
                return 0;
        }

        if (storage[i][j]!=-1) {
            counter++;
            return storage[i][j];
        }
        int ans=0;
        if (s2.charAt(i-1)==s1.charAt(j-1))
        {
            boolean flag=false;
            if (i>=2)
            if (s2.charAt(i-1)==s2.charAt(i-2))
            {
               int  index=-1;
                flag=true;
                for (int k=j-2;k>=0;k--)
                {
                    if (s1.charAt(k)==s2.charAt(i-1))
                    {

                        index=k;
                        ans+=compute(i-1,index);
                    }
                }

                    ans+=compute(i-1,j-1);


            }
            if (!flag)
                ans=compute(i-1,j)+compute(i,j-1);
        }
        else
        {
            ans=compute(i,j-1);
        }
        return storage[i][j]=ans;
    }

}
public class DistinctSubsequence {


    public static void main(String[] args) {
        DistinctSubsequenceHandler handler=new DistinctSubsequenceHandler();
        String s1,s2;
        System.out.println("Enter String 1");
        Scanner scanner=new Scanner(System.in);
        s1=scanner.nextLine();
        System.out.println("Enter String 2");
        s2=scanner.nextLine();
        handler.input(s1,s2);
        System.out.println("The Total Ways "+handler.compute(s2.length(),s1.length()));
        System.out.println("Total Call Escaped "+handler.counter);
    }
}
