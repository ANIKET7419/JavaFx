package Comp_P.BruteForce;

import javafx.scene.control.skin.CellSkinBase;

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
