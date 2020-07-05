package Comp_P.Contest;

import java.util.ArrayList;
import java.util.Scanner;

public class ArithmeticSequence {
    int data[];
    ArrayList<Integer> result;
    boolean traversed[];
    void input(int data[])
    {
        this.data=data;
        result=new ArrayList<>();
        traversed=new boolean[data.length];
    }
    boolean isvalid(ArrayList <Integer> list)
    {
        if (list.size()==1)
            return true;


        int diffrence=list.get(1)-list.get(0);
         for (int i=1;i<list.size()-1;i++)
         {
             if (diffrence!=list.get(i+1)-list.get(i)) {
                 return false;
             }
         }
         return true;
    }
    boolean canMake()
    {
        if (result.size()==data.length)
        {

            if (isvalid(result))
            {

                return true;
            }
            else
            {
                return false;
            }
        }
        for (int i=0;i<data.length;i++)
        {
            if (!traversed[i]) {
                result.add(data[i]);
                traversed[i]=true;
                if (canMake())
                    return true;
                result.remove(result.size()-1);
                traversed[i]=false;
            }
        }
        return false;



    }

    public static void main(String[] args) {
        System.out.println("Enter Data Size");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int data[]=new int[n];
        for (int i=0;i<n;i++)
            data[i]=scanner.nextInt();
        ArithmeticSequence sequence =new ArithmeticSequence();
        sequence.input(data);
        System.out.println("Result "+sequence.canMake());
    }
}