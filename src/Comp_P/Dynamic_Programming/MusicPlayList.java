package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class MusicPlayListHandler
{
    int N,K,L;
    void input(int N,int K,int L)
    {
        this.N=N;
        this.K=K;
        this.L=L;
    }
    int totalways()
    {
        int ways=1;
        int dp[]=new int[L+1];
        dp[0]=0;
        int tempN=N;
        int KpositionerS=1;
        dp[1]=tempN;
        tempN--;
        for (int i=2;i<L+1;i++)
        {
            if (i-KpositionerS==(K+1))
            {
                KpositionerS+=1;
                tempN+=1;
            }
            dp[i]=tempN;
            tempN--;
        }

        for (int i=1;i<L+1;i++)
        {
            ways*=dp[i];
        }
        return ways;
    }
}
public class MusicPlayList {
    public static void main(String[] args) {
        int N,K,L;
        System.out.println("Enter  Different  number of songs ");
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        System.out.println("Enter Playlist size");
        L=scanner.nextInt();
        System.out.println("Enter Value of K");
        K=scanner.nextInt();
        MusicPlayListHandler handler =new MusicPlayListHandler();
        handler.input(N,K,L);
        System.out.println("The Total  Ways "+handler.totalways());
    }
}
