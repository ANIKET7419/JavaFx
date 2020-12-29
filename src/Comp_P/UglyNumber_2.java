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
      for(int i=1;i<n;i++)
      {
         int min= Math.min(result.get(two)*2,Math.min(result.get(three)*3,result.get(five)*5));
         if (min==result.get(two)*2)
             two++;
          if (min==result.get(three)*3)
             three++;
         if (min==result.get(five)*5)
             five++;
          result.add(min);
      }
      System.out.println(result);
      System.out.println(n+" th Ugly number is "+result.get(n-1));




    }




}
