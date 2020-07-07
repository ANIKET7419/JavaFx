package Comp_P.Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;
// for just  reference video  https://leetcode.com/problems/dungeon-game/discuss/704381/Video-explanation
class DungeonGameHandler
{
    int data[][];
    int storage[][];
    void input(int data[][])
    {

        storage=new int[data.length][data[0].length];
        for (int t[]:storage)
            Arrays.fill(t,-1);
        this.data=data;
    }
    int minimumHp(int i,int j)
    {
        if(i==data.length-1&&j==data[0].length-1)
            return storage[i][j]=Math.max(1,1-data[i][j]);
        else if (i>=data.length||j>=data[0].length)
            return -1;
        if (storage[i][j]!=-1)
            return storage[i][j];
        int temp1= minimumHp(i+1,j);
        int temp2=  minimumHp(i,j+1);
        if (temp1==-1&&temp2!=-1)
            return storage[i][j]=Math.max(1,temp2-data[i][j]);
        else if (temp1!=-1&&temp2==-1)
            return storage[i][j]=Math.max(1,temp1-data[i][j]);
        else
        {
            int min=Math.min(temp1,temp2);
            return storage[i][j]=Math.max(1,min-data[i][j]);
        }

    }
}

public class DungeonGame {
    public static void main(String[] args) {
        DungeonGameHandler handler =new DungeonGameHandler();
        int n,m;
        System.out.println("Enter Number of rows");
        Scanner scanner =new Scanner(System.in);
        n=scanner.nextInt();
        System.out.println("Enter Number of Column");
        m=scanner.nextInt();
        System.out.println("Enter Data ");
        int data[][]=new int[n][m];
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                data[i][j]=scanner.nextInt();
            }
        }
        handler.input(data);
        int result=handler.minimumHp(0,0);
        System.out.println("The Minimum Initial Hp should be "+result);
    }
}
