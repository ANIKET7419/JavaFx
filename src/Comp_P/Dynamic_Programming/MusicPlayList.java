package Comp_P.Dynamic_Programming;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.Arrays;
import java.util.Scanner;

class MusicPlayListHandler
{
    int N,K,L;
    int data[];
    String result="";
    int whichvisited[];
    boolean isvisitedfornotreuse[];
    void input(int N,int K,int L)
    {
        this.N=N;
        this.K=K;
        this.L=L;
        data=new int[N];
        for (int i=0;i<N;i++)
            data[i]=i+1;
        whichvisited=new int[L];
        Arrays.fill(whichvisited,-1);
        isvisitedfornotreuse=new boolean[N];
        Arrays.fill(isvisitedfornotreuse,false);
    }
    void permutation(int KPositioner,int depth)
    {
        if (result.length()==L)
        {
            System.out.println(result);
            return;
        }
        for (int i=0;i<data.length;i++)
        {
            if (!isvisitedfornotreuse[i])
            {
                String temp=result;
                result+=data[i];
                isvisitedfornotreuse[i]=true;
                whichvisited[depth]=i;
                permutation(KPositioner,depth+1);
                whichvisited[depth]=-1;
                isvisitedfornotreuse[i]=false;
                result=temp;
            }
        }
        if ((depth-KPositioner)==K+1) {


            int m=0;
            int reusedata[]=new int[L];
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
                if (!flag&&whichvisited[i]!=-1)
                   reusedata[m++]=whichvisited[i];
            }
            KPositioner++;
            for (int k = 0; k < m; k++) {
                String temp=result;
                result+=data[reusedata[k]];
                whichvisited[depth]=reusedata[k];
                permutation(KPositioner,depth+1);
                whichvisited[depth]=-1;
                result=temp;
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
