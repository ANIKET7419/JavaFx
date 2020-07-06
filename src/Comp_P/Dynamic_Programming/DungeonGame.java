package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class DungeonGameHandler
{
    int data[][];
    void input(int data[][])
    {
        this.data=data;
    }
    int [] minimumHp(int i,int j)
    {
        if (i==0&&j==0)
        if (data[i][j]>0)
                return new int[]{1,data[i][j]+1};
            else
                return new int[]{1-data[i][j],1};
        else if (i<0||j<0)
            return new int[]{-1,-1};
        else
        {
            int result[]=new int[2];
            int result2[]=new int[2];
           int temp1[]= minimumHp(i-1,j);
           int temp2[]= minimumHp(i,j-1);
           if (temp2[0]!=-1)
           {
               int value=temp2[1]+data[i][j];
               if (value<=0)
               {
                   result[0]=temp2[0]+(1-value);
                   result[1]=1;
               }
               else {
                   result[0]=temp2[0];
                   result[1] = value;
               }
           }
           if (temp1[0]!=-1)
           {
               int value=temp1[1]+data[i][j];
               if (value<=0)
               {
                   result2[0]=temp1[0]+(1-value);
                   result2[1]=1;
               }
               else {
                   result2[0]=temp1[0];
                   result2[1] = value;
               }
           }
           if (result[0]==0)
               return result2;
           else if (result2[0]==0)
               return result;
           else
               return result[0]<result2[0]?result:result2;

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
        int result[]=handler.minimumHp(data.length-1,data[0].length-1);
        System.out.println("The Minimum Initial Hp should be "+result[0]);
    }
}
