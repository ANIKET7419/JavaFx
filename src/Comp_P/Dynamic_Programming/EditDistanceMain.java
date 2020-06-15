package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class EditDistance
{
    String word1,word2;
    int storage[][];
    EditDistance(String word1, String word2)
    {
        this.word1=word1;
        this.word2=word2;
        storage=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;i++)
        {
            for (int j=0;j<word2.length()+1;j++)
            {
                storage[i][j]=-1;
            }
        }
    }
    int totalDistance(int i,int j)
    {
        if(i==0||j==0)
        { if(i==j)
            {
                storage[i][j]=0;
                return 0; }
            else
            { if(i==0)
                { storage[i][j]=j;
                    return j; }
                else{
                    storage[i][j]=i;
                    return i;}}}
        if(storage[i][j]!=-1)
            return storage[i][j];
        if(word1.charAt(i-1)==word2.charAt(j-1))
        {
            storage[i][j]= totalDistance(i-1,j-1);
            return storage[i][j];
        }
        else
        {
            storage[i][j]= Math.min(totalDistance(i-1,j-1),Math.min(totalDistance(i-1,j),totalDistance(i,j-1)))+1;
            return storage[i][j];
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
