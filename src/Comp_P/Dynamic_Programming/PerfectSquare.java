
package Comp_P.Dynamic_Programming;
import java.util.Arrays;
import java.util.Scanner;

class PerfectSquareHandler
{
    int n;
    int storage[];
    int counter=0;
    void input(int n)
    {

        this.n=n;
        storage=new int[n+1];
        Arrays.fill(storage,-1);
    }
    int  perfectsquare(int k)
    {
        if (storage[k]!=-1) {
            counter++;
            return storage[k];
        }
        double root=Math.sqrt(k);
        if(root==((int)root))
            return storage[k]=1;
        int end=(k-1)%2==0?(k-1)/2:((k-1)/2)+1;
        int counter=Integer.MAX_VALUE;
        for (int l=k-1;l>=end;l--)
        {
            int temp=perfectsquare(l)+perfectsquare(k-l);
            if (temp<counter)
                counter=temp;
        }


        return storage[k]=counter;
    }

}
public class PerfectSquare {
    public static void main(String[] args) {
        PerfectSquareHandler handler =new PerfectSquareHandler();
        int n;
        System.out.println("Enter Number");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        handler.input(n);
        System.out.println("The Result is "+handler.perfectsquare(n));
        System.out.println("Total Call Escaped "+handler.counter);
    }
}
