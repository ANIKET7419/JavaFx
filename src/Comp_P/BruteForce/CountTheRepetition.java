package Comp_P.BruteForce;
//This  approach is not useful for long input there it may cause  stack overflow error because of recursion


/*



Better Brute Force Approach

prefer https://leetcode.com/problems/count-the-repetitions/Figures/466/count_the_repititions.png for understanding

class Solution
{

    public:

    int getMaxRepetitions(string s1, int n1, string s2, int n2)
{
    if (n1 == 0)
        return 0;
    int indexr[s2.length() + 1]; // index at start of each s1 block
        indexr[0]=0;
    int countr[s2.length()+ 1]; // count of repititions till the present s1 block
        countr[0]=0;
    int index = 0, count = 0;
    for (int i = 0; i < n1; i++) {
        for (int j = 0; j < s1.size(); j++) {
            if (s1[j] == s2[index])
                ++index;
            if (index == s2.size()) {
                index = 0;
                ++count;
            }
        }
        countr[i] = count;
        indexr[i] = index;
        for (int k = 0; k < i; k++) {
            if (indexr[k] == index) {
                int prev_count = countr[k];
                int pattern_count = (countr[i] - countr[k]) * ((n1  - k-1) / (i - k));
                int remain_count = countr[k + (n1 - k-1) % (i - k)] - countr[k];
                return (prev_count + pattern_count + remain_count) / n2;
            }
        }
    }
    return countr[n1 - 1] / n2;
}};



 */

import java.util.Scanner;

class CountTheRepetitionHandler
{
    String s1,s2;
    int n1,n2;
    void input(String s1,int n1,String s2,int n2){
        this.s1=s1;
        this.s2=s2;
        this.n1=n1;
        this.n2=n2;
    }
    int maximumrepetition(int index1,int index2,int repetition1,int repetition2)
    {

        int result=0;
        if (repetition1==n1)
        {
                 if (repetition2!=n2)
                  return 0;
                 else
                     return 1;
        }
        if (repetition2==n2)
        {
            repetition2=0;
            result+=1;
        }

        if (s1.charAt(index1)==s2.charAt(index2))
        {
            if (index1==s1.length()-1&&index2==s2.length()-1)
            {
               result+= maximumrepetition(0,0,repetition1+1,repetition2+1);
            }
            else if (index1==s1.length()-1){

                result+= maximumrepetition(0,index2+1,repetition1+1,repetition2);
            }
            else if(index2==s2.length()-1)
            {
                result+= maximumrepetition(index1+1,0,repetition1,repetition2+1);
            }
            else {
                result+= maximumrepetition(index1+1,index2+1,repetition1,repetition2);
            }


        }
        else
        {


            if (index1==s1.length()-1)
            {
               result+= maximumrepetition(0,index2,repetition1+1,repetition2);
            }
          else
            {
             result+=   maximumrepetition(index1+1,index2,repetition1,repetition2);
            }

        }

       return result;
    }


}
public class CountTheRepetition {


    public static void main(String[] args) {
        CountTheRepetitionHandler handler=new CountTheRepetitionHandler();
        int n1,n2;
        String s1,s2;
        System.out.println("Enter  String 1 Length");
        Scanner scanner=new Scanner(System.in);
        n1=scanner.nextInt();
        System.out.println("Enter String 2 length");
        n2=scanner.nextInt();
        System.out.println("Enter String 1");
        s1=scanner.nextLine();
        System.out.println("Enter String 2 ");
        s2=scanner.nextLine();
        handler.input("baba",2,"baab",1);
        System.out.println("The Maximum Repetition "+handler.maximumrepetition(0,0,0,0));


    }
}
