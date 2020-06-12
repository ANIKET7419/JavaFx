package Comp_P;

import java.util.Scanner;
/*
Aniket
10 JUNE 2020


In this code i have shown how mcm format work
1. If a function can have many solutions then we can not use dynamic programming
2. Then we have to use Backtracking
3. There are very low chances of using dynamic programming with backtracking
4. In Backtracking most of time we get answer in the last  depth
5. If Using Base Condition we make solution of bigger problem
   Like base case return small result and we use this result to make result of whole problem then most of time we cant use backtracking
6. If a function have only one solution with particular value then we can use dynamic programming

 */

class format
{
    String data=null;
    String original=null;
    void input(String data)
    {
        this.data=data;
        this.original=data;
    }
    void recursive(int i,int j, int depth)
    {


        if(i>=j)
        {
            return;
        }
        if(depth==original.length()-2) {
            System.out.println(data);
            return;
        }
        for(int k=i;k<j;k++)
        {
            String temp=data;
            data=data.substring(0,i)+"("+data.substring(i,k+1)+")("+data.substring(k+1,j+1)+")"+((data.substring(j+1,data.length())));
            recursive(i+1,k+1,depth+1);
            recursive(k+4,j+3,depth+1);
            data=temp;

        }


    }


}
public class MCM {


    public static void main(String[] args) {
        format object=new format();
        String data;
        System.out.println("Enter Data");
        Scanner scanner=new Scanner(System.in);
        data=scanner.nextLine();
        object.input(data);
        object.recursive(0,data.length()-1,0);
    }
}
