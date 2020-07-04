package Comp_P.BruteForce;

import java.util.Scanner;

class CountTheRepetitionBetterHandler
{
    String s1,s2;
    int n1,n2;
    void input(String s1,int n1,String s2,int n2)
    {
        this.s1=s1;
        this.s2=s2;
        this.n1=n1;
        this.n2=n2;
    }
    int totalR()
    {
        int indexr[]=new int[s2.length()+1];
        int countr[]=new int[s2.length()+1];
        indexr[0]=0;
        countr[0]=0;
        int index=0,count=0;
        for (int i=0;i<n1;i++)
        {
            for(int j=0;j<s1.length();j++)
            {

                if (s1.charAt(j)==s2.charAt(index))
                {
                    index=index+1;
                }
                if (index==s2.length())
                {
                    index=0;
                    count=count+1;
                }
            }
            indexr[i+1]=index;
            countr[i+1]=count;

            for (int k=0;k<=i;k++)
            {
                if (indexr[k]==indexr[i+1])
                {
                    int previous_count=countr[k];
                    int count1=(countr[i+1]-countr[k])*((n1-k)/(i+1-k));
                    int remaining=countr[k+((n1-k)%(i+1-k))]-countr[k];
                    return (previous_count+count1+remaining)/n2;

                }
            }
        }
        return countr[n1]/n2;
    }


}
public class CountTheRepeititonBetter {
    public static void main(String[] args) {
        CountTheRepetitionBetterHandler handler=new CountTheRepetitionBetterHandler();
        int n1,n2;
        String s1,s2;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter  String 1");
        s1=scanner.nextLine();
        System.out.println("Enter String 2");
        s2=scanner.nextLine();
        System.out.println("Enter The value of n1");
        n1=scanner.nextInt();
        System.out.println("Enter The value of n2");
        n2=scanner.nextInt();
        handler.input(s1,n1,s2,n2);
        System.out.println("The Total Repetition is "+handler.totalR());
    }
}
