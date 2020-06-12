package Comp_P;

import java.util.HashSet;
import java.util.Scanner;

class Solution_sqrt {
    public int mySqrt(int x) {
        double start=0,end=((double)x/2)+1;
        for(int i=0;i<x;i++)

        {
            double mid = (start + end) / 2;
            if (mid * mid - x >= 0) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return (int)end;

    }
}
public class sqrt {
    public static void main(String[] args) {
        Solution_sqrt object=new Solution_sqrt();
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        System.out.println(object.mySqrt(x));
    }


}
