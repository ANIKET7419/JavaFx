package Comp_P;

import java.util.Scanner;

public class _123_Sub {
    static class fine
    {
        static  int ok=190;
    }

    public  static boolean result(int data[])
    {
        int var=1;
        for(int i=0;i<data.length;i++)
        {
            if (data[i]==var)
            {
                if (var==1)
                    var=3;
                else  if (var==3)
                    var=2;
                else
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of elements ");
        int n=scanner.nextInt();
        System.out.println("Enter data");
        int data[]=new int[n];
        for (int i=0;i<n;i++)
            data[i]=scanner.nextInt();
        System.out.println("Is there any 132 subsequence : "+result(data));

    }


}
