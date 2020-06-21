package Comp_P.BruteForce;

import java.util.Scanner;

class JumpGameHandler {
    int data[];

    int minimum_jump=Integer.MAX_VALUE;
    void input(int data[])
    {
        this.data=data;
    }
    void makejump(int index,int depth)
    {

        if(index==data.length-1)
        {
            if(minimum_jump>depth)
            minimum_jump=depth;
            return;
        }
        if (index>=data.length)
            return;

        for (int i=index+1;i<=data[index]+index;i++)
        {
            makejump(i,depth+1);
        }
    }


}
public class JumpGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        JumpGameHandler handler=new JumpGameHandler();
        int data[];
        System.out.println("Enter Length of the data");
        int n=scanner.nextInt();
        data=new int[n];
        System.out.println("Enter Data");
        for (int i=0;i<n;i++)
        {
            data[i]=scanner.nextInt();
        }
        handler.input(data);
        if (data.length!=0&&data.length!=1)
        handler.makejump(0,0);
        else
            handler.minimum_jump=0;
        System.out.println("The Minimum jump  is "+handler.minimum_jump);

    }
}
