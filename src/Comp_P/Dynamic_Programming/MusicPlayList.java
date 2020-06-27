package Comp_P.Dynamic_Programming;

/*
Your music player contains N different songs and she wants to listen to L (not necessarily different) songs during your trip.  You create a playlist so that:

Every song is played at least once
A song can only be played again only if K other songs have been played
Return the number of possible playlists.  As the answer can be very large, return it modulo 10^9 + 7.




But in this i showed all permutations
it is not dp it is backtracking
Dp solution is also being tried  named as MusicPlayerListDP
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class MusicPlayListHandler
{
    int N,K,L;
    int data[];
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
    void permutation(int KPositioner,int depth)
    {
        if (result.size()==L)
        {
            if (allavailable()) {
                System.out.println(result);
            }
            return;
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
                permutation(KPositioner,depth+1);
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
                permutation(KPositioner,depth+1);
                whichvisited[depth]=-1;
                isvisitedfornotreuse[i]=false;
                result.remove(result.size()-1);
            }
        }

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
        handler.permutation(0,0);

    }
}
