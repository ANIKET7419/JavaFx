/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */


package Comp_P.Window_Sliding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

class MinimumWindowSubstringHandler
{
    String s1,s2;
    void input(String s1,String s2)
    {
        this.s1=s1;
        this.s2=s2;
    }
    String result()
    {
      int i=0;
      int j=0;
      int k=0;
        HashMap map=new HashMap();
        int minimum_begin=-1,minimum_end=-1;
        while (j<s1.length())
        {
            k=0;
            map.put(j,s1.charAt(j));
            j++;
            for (int l=0;j<s2.length();j++)
                if (map.containsValue(s2.charAt(l)))
                    k++;
            if(k==s2.length())
            {
                minimum_begin=i;
                minimum_end=j-1;
                map.remove(i++);
            }
        }


        return minimum_begin==-1&&minimum_end==-1?"":s1.substring(minimum_begin,minimum_end+1);
    }

}
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstringHandler handler =new MinimumWindowSubstringHandler();
        String s1,s2;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String 1 ");
        s1=scanner.nextLine();
        System.out.println("Enter String 2 ");
        s2=scanner.nextLine();
        handler.input(s1,s2);
       System.out.println("The Result is "+ handler.result());
    }
}
