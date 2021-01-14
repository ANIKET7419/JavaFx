package Comp_P;

import java.util.HashSet;
import java.util.Scanner;

public  class WordLadder
{
    static HashSet<String> set;
    static HashSet<String > traversed=new HashSet<>();
    static int minimum(String current,String end,int count)
    {
     if (current.equals(end)) {
         return 0;
     }
        if (count>=set.size()+2) {
            return count;
        }

        traversed.add(current);
     int result=Integer.MAX_VALUE;
     for (int i=0;i<current.length();i++)
     {
        for (char j='a';j<='z';j++)
        {
        String temp=current.substring(0,i)+j+current.substring(i+1);
        if (set.contains(temp)&&!traversed.contains(temp)) {
            result = Math.min(minimum(temp, end, count + 1) + 1, result);
        }
        }
     }
     traversed.remove(current);
    return  result==Integer.MAX_VALUE?set.size()+2:result;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word list size");
        int n = scanner.nextInt();
        set = new HashSet<String>();
        for (int i = 0; i < n; i++)
            set.add(scanner.next());
        System.out.println("Enter start word");
        String start = scanner.next();
        System.out.println("Enter end word");
        String end = scanner.next();
        if (!set.contains(end)) {
            System.out.println("Result is 0");
        } else {
            int result = minimum(start, end, 0);
            if (result >= set.size() + 2)
                result = 0;
            else
                result+=1;
            System.out.println("The minimum required transformation is -> " +result);
        }
    }
}
