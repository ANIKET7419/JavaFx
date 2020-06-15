package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class EditDistance
{
    String word1,word2;
    EditDistance(String word1, String word2)
    {
        this.word1=word1;
        this.word2=word2;
    }
    int totalDistance(int i,int j)
    {
        if(i==0||j==0)
        { if(i==j)
            { return 0; }
            else
            { if(i==0)
                { return j; }
                else return i;}}
        if(word1.charAt(i-1)==word2.charAt(j-1))
        {
            return totalDistance(i-1,j-1);
        }
        else
        {
            return Math.min(totalDistance(i-1,j-1),Math.min(totalDistance(i-1,j),totalDistance(i,j-1)))+1;
        }

    }

}
public class EditDistanceMain {
    public static void main(String[] args) {
        String word1,word2;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String 1 ");
        word1=scanner.nextLine();
        System.out.println("Enter String 2");
        word2=scanner.nextLine();
        EditDistance object=new EditDistance(word1,word2);
        System.out.println("The Minimum cost is "+object.totalDistance(word1.length(),word2.length()));
    }
}
