package Comp_P;

import java.util.Arrays;
import java.util.Scanner;

public class WithDP {

    static int steps[];
    static int storage[];
    static int solver(int index){

        if (index==steps.length-1){
            return storage[index]=0;
        }
        else if (index>=steps.length)
            return -1 ; // i used -1 just for indication that we have to discard this path bcz hmne top stair ko cross kar liya hai
        else{


            if (storage[index]!=Integer.MIN_VALUE)
                return storage[index];

            int result=Integer.MAX_VALUE;
            for (int k=1;k<=steps[index];k++){
                int temp=solver(index+k);
                if (temp!=-1){
                    result=Math.min(result,temp+1);
                }
            }
            return storage[index]=(result==Integer.MAX_VALUE?-1:result);
        }
    }


    public static void main(String[] args) {
        System.out.println("Enter number of stairs ");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        steps=new int[n];
        System.out.println("Enter values ");
        for(int i=0;i<n;i++)
            steps[i]=scanner.nextInt();
        storage=new int[n];
        Arrays.fill(storage,Integer.MIN_VALUE);
        System.out.println("The result is "+solver(0));
    }
}
