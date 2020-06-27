package Comp_P.Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//This DP solution is not working yet please use only backtracking solution


/*

THis is dp approach actually useful

class Solution {
    public int numMusicPlaylists(int N, int L, int K) {
        int MOD = 1_000_000_007;

        long[][] dp = new long[L+1][N+1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; ++i)
            for (int j = 1; j <= N; ++j) {
                dp[i][j] += dp[i-1][j-1] * (N-j+1);
                dp[i][j] += dp[i-1][j] * Math.max(j-K, 0);
                dp[i][j] %= MOD;
            }
  for(long temp[]:dp)
  {
      for(long data:temp)
      {
          System.out.print(data+" ");
      }
      System.out.println();
  }

        return (int) dp[L][N];
    }
}


 */
class MusicPlayListHandlerDP
{
    int N,K,L;
    int data[];
    int storage[][];
    int counter=0;
    ArrayList <Integer>result;
    int whichvisited[];
    boolean isvisitedfornotreuse[];
    void input(int N,int K,int L)
    {
        this.N=N;
        this.K=K;
        this.L=L;
        result=new ArrayList<>();
        data=new int[N];
        for (int i=0;i<N;i++)
            data[i]=i+1;
        whichvisited=new int[L];
        Arrays.fill(whichvisited,-1);
        isvisitedfornotreuse=new boolean[N];
        storage=new int[L+1][L+1];
        for (int temp[]:storage)
            Arrays.fill(temp,-1);
        Arrays.fill(isvisitedfornotreuse,false);
    }
    boolean allavailable()
    {
        boolean flag=false;
        for (int k=0;k<data.length;k++) {
            flag=false;
            for (int i = 0; i < result.size(); i++) {

                if (result.get(i)==data[k])
                {
                    flag=true;
                }
            }
            if (flag==false)
                break;
        }
        return flag;
    }
    int  permutation(int KPositioner,int depth)
    {
        if (result.size()==L)
        {
            if (allavailable()) {
                return 1;
            }
            return 0;
        }
        int totalways=0;
        if(storage[KPositioner][depth]!=-1) {
            counter++;
            return storage[KPositioner][depth];
        }
        if ((depth-KPositioner)==K+1) {

            int m=0;
            int reusedata[]=new int[L];
            Arrays.fill(reusedata,-1);
            for (int i=0;i<=KPositioner;i++)
            {
                boolean flag=false;
                for (int p=0;p<L;p++)
                {
                    if (whichvisited[i]==reusedata[p])
                    {
                        flag=true;
                        break;
                    }
                }
                for (int p=KPositioner+1;p<depth;p++)
                {
                    if (whichvisited[i]==whichvisited[p])
                    {
                        flag=true;
                        break;
                    }
                }
                if (!flag&&whichvisited[i]!=-1)
                    reusedata[m++]=whichvisited[i];
            }
            KPositioner++;
            for (int k = 0; k < m; k++) {
                result.add(data[reusedata[k]]);
                whichvisited[depth]=reusedata[k];
              totalways+=  permutation(KPositioner,depth+1);
                whichvisited[depth]=-1;
                result.remove(result.size()-1);
            }
        }
        for (int i=0;i<data.length;i++)
        {
            if (!isvisitedfornotreuse[i])
            {
                result.add(data[i]);
                isvisitedfornotreuse[i]=true;
                whichvisited[depth]=i;
               totalways+=permutation(KPositioner,depth+1);
                whichvisited[depth]=-1;
                isvisitedfornotreuse[i]=false;
                result.remove(result.size()-1);
            }
        }
      return storage[KPositioner][depth]=totalways;
    }
}
public class MusicPlayListDP {
    public static void main(String[] args) {
        int N,K,L;
        System.out.println("Enter  Different  number of songs ");
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        System.out.println("Enter Playlist size");
        L=scanner.nextInt();
        System.out.println("Enter Value of K");
        K=scanner.nextInt();
        MusicPlayListHandlerDP handler =new MusicPlayListHandlerDP();
        handler.input(N,K,L);
       System.out.println("Total Ways "+ handler.permutation(0,0));
       System.out.println("Total Calls Escaped "+handler.counter);
    }
}
