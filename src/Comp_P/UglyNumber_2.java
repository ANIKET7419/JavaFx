package Comp_P;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.youtube.com/watch?v=gyYHKbvxOlA
public class UglyNumber_2 {


    public static void main(String[] args) {

      System.out.println("Enter Number ");
      Scanner scanner=new Scanner(System.in);
      int n=scanner.nextInt();
      int two=0;
      int three=0;
      int five=0;
      List<Integer> result=new ArrayList<>();
      result.add(1);
      for(int i=0;i<n;i++)
      {
         int min= Math.min(result.get(two)*2,Math.min(result.get(three)*3,result.get(five)*5));
         result.add(min);
         if (min==result.get(two)*2)
             two++;
         else if (min==result.get(three)*3)
             three++;
         else
             five++;
      }
      System.out.println(n+" th Ugly number is "+result.get(n-1));




    }




}
