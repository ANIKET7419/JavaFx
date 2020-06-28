package Comp_P.Dynamic_Programming;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Arrays;
import java.util.Scanner;

/*
Question:
Given a string S, count the number of distinct, non-empty subsequences of S .

Since the result may be large, return the answer modulo 10^9 + 7.


Answer ->

As we know if there is no any duplicate element then answer is 2^n-1
if there is duplicate we will remove all those values appended before  previous  last same character means for example aaa for third a we remove till first a


Explanation->
for string abc

index 0: result -> "","a"
index 1 : result ->  previous values + previous values with appended charAt(1)
                  -> "","a" + "b","ab"
index 2 : result -> "","a","b","ab"+ "c","ac","bc","abc"
length of index 2 result is 8 but the actual result will be 7 because "" will not be considered


for string aba


index 0: result -> "","a"
index 1 : result ->"","a"+ "b","ab"
index 2 : because it is duplicate value so the result will be now
          result-> ("","a","b","ab" + "a","aa","ba","aba") - result of before last a ("")  this condition is for quantity not actually for combination string
          result -> ("b","ab","a","aa","ba","aba","a")
          value returned will be result.length-1;
 */
class DistinctSubsequenceHandler2
{
 String data;
 int traversed[];
 void input(String data)
 {
     this.data=data;
     int max=Character.MAX_VALUE;
     traversed=new int[max+1];
     Arrays.fill(traversed,-1);
 }
 int totalways(int i)
 {
     // i  represents length
     if (i==0||i<0)
         return 1;//"" string
     int result;
     result=totalways(i-1)*2;
     //traversed[(int)data.charAt(i-1)]<i is used to prevent stack overflow error
     if (traversed[(int)data.charAt(i-1)]!=-1&&traversed[(int)data.charAt(i-1)]<i) {
         int temp= totalways(traversed[(int) data.charAt(i - 1)] - 1);
         System.out.println(temp+" "+i);
         result-=temp;
     }
     traversed[(int)data.charAt(i-1)]=i;
  return result;
 }
}
public class DistinctSubsequence2 {


    public static void main(String[] args) {
        DistinctSubsequenceHandler2 handler2=new DistinctSubsequenceHandler2();
        String data;
        System.out.println("Enter String ");
        Scanner scanner=new Scanner(System.in);
        data=scanner.nextLine();
        handler2.input(data);
        System.out.println("The Total ways are "+(handler2.totalways(data.length())-1));
    }
}
