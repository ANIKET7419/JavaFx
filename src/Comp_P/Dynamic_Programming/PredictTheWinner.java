package Comp_P.Dynamic_Programming;

import java.net.SecureCacheResponse;
import java.util.Scanner;

class PredictTheWinnerHandler
{
    int data[];
    void input(int data[])
    {
        this.data=data;
    }
    boolean predict(int i,int j,boolean turn,int firstscore,int secondscore)
    {

        if (i==j)
        {
            if (turn)
            {
                if (firstscore+data[i]>secondscore)
                {
                    return true;
                }
                else
                    return false;
            }
            else {
                if (secondscore+data[i]>firstscore)
                {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        boolean temp1,temp2;
        if (turn) {
            temp1=predict(i + 1, j,!turn,firstscore+data[i],secondscore);
           temp2=predict(i,j-1,!turn,firstscore+data[j],secondscore);
        }
        else {
            temp1=predict(i + 1, j,!turn,firstscore,secondscore+data[i]);
            temp2=predict(i,j-1,!turn,firstscore,secondscore+data[j]);
        }

        return temp1 || temp2;
    }

}
public class PredictTheWinner {
    public static void main(String[] args) {
        PredictTheWinnerHandler handler=new PredictTheWinnerHandler();
        System.out.println("Enter the length of the data");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println("Enter Data");
        int data[]=new int[n];
        for (int i=0;i<n;i++)
            data[i]=scanner.nextInt();
        handler.input(data);
       System.out.println("The Result is "+handler.predict(0,data.length-1,true,0,0));
    }
}
