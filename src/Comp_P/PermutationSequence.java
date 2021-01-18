package Comp_P;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PermutationSequence {

static String result;
    static int fac(int i)
    {
        if(i==0)
            return 1;
        return i*fac(i-1);
    }

    static void permutation(int org,int n,int k,String per)
    {
        if(n==0) {
            result = per;
            return;
        }
       ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=org;i++) {
            if(per.indexOf((char)(48+i))<0)
            list.add(i);
        }
        Collections.sort(list,(a,b)->a-b);
        int current_perm=fac(n);
        int total_slices=current_perm/n;
        int current=1;
        int index=0;
        int offset=0;
        while (current<=current_perm)
        {
            if(k>=current&&k<=current+total_slices-1)
            {
                offset=current-1;
                break;
            }
            current+=total_slices;
            index++;
        }
        int value=list.get(index);
        permutation(org,n-1,k-offset,per+value);
    }

    public static void main(String[] args) {

        System.out.println("Enter value of n ");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println("Enter the value of k ");
        int k=scanner.nextInt();
        permutation(n,n,k,"");
        System.out.println("The result is "+result);

    }

}
