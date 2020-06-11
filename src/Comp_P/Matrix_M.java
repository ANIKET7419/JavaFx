package Comp_P;
import java.util.Scanner;
class  Matrix_handler
{
    int data[];
    void input(int data[])
    {
        this.data=data;
    }
    int recursive(int i,int j)
    {
        if(i>=j)
        {
            return 0;
        }
        int min_cost=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int temp=recursive(i,k)+recursive(k+1,j)+(data[i]*data[k+1]*data[j+1]);
            if(min_cost>temp)
            {
                min_cost=temp;
            }
        }
        return min_cost;
    }
}
public class Matrix_M {

    public static void main(String[] args) {
     Matrix_handler handler=new Matrix_handler();
     System.out.println("Enter Size");
        Scanner scanner=new Scanner(System.in);

      int n=scanner.nextInt();
        int data[]=new int[n];
        System.out.println("Enter data");
        for (int i=0;i<n;i++)
        {
            data[i]=scanner.nextInt();
        }
        handler.input(data);
        System.out.println("The Minimum Cost to Solve Multiplication is  "+handler.recursive(0,n-2));
    }


}
