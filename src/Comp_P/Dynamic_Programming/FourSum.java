package Comp_P.Dynamic_Programming;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FourSumHandler
{
    int data[];
    void input(int data[])
    {
        this.data=data;
    }
    List<List<Integer>> fourpairs(int  target ,int index,int required)
    {
        if (required==0)
            return null;
        List<List<Integer>> result=new ArrayList<>();

        for (int i=index+1;i<data.length;i++)
        {
          List<List<Integer>> temp=fourpairs(target-data[index],i,required-1);
          if (temp!=null) {
              for (List list : temp) {
                  List<Integer> loweresult = new ArrayList<>();
                  loweresult.add(data[index]);
                  for (Object value : list) {
                      int value1 = (Integer) value;
                      loweresult.add(value1);
                  }
                  result.add(loweresult);
              }
          }
          else
          {
              if (target==data[index]) {

                  List<Integer> temp1 = new ArrayList<>();
                  temp1.add(data[index]);
                  result.add(temp1);
              }
          }
        }
        return result;
    }



}
public class FourSum {
    public static void main(String[] args) {
        FourSumHandler handler =new FourSumHandler();
        int n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Length ");
        n=scanner.nextInt();
        System.out.println("Enter Data ");
        int data[]=new int[n];
        for (int i=0;i<n;i++)
            data[i]=scanner.nextInt();
        int target;
        System.out.println("Enter the target ");
        target=scanner.nextInt();
        handler.input(data);
        System.out.println("The Result is "+handler.fourpairs(target,0,4));

    }
}
