package Comp_P;
import java.util.Scanner;
import java.util.Stack;
class BaseBallGameHandler
{
    String data[];
    void input(String data[]){
        this.data=data;
    }
    int points()
    {
        Stack<Integer> stack=new Stack();
        for (int i=0;i<data.length;i++)
        {
            if (data[i].equals("+"))
            {
                if (stack.size()>=2)
                {
                    int first=stack.pop();
                    int second=stack.pop();
                    int result=first+second;
                    stack.push(second);
                    stack.push(first);
                    stack.push(result);
                }

            }
            else if (data[i].equals("C"))
            {
                if (!stack.empty())
                stack.pop();
            }
            else if (data[i].equals("D"))
            {
                if (!stack.empty())
                {
                    int el=stack.pop();
                    int result=el*2;
                    stack.push(el);
                    stack.push(result);
                }

            }
            else
            {
                stack.push(Integer.parseInt(data[i]));
            }
        }

        int sum=0;
        while (!stack.empty())
        {
            sum+=stack.pop();
        }
        return sum;
    }




}
public class BaseBallGame {
    public static void main(String[] args) {
        BaseBallGameHandler handler=new BaseBallGameHandler();
        int n;
        System.out.println("Enter The Number of rounds ");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        System.out.println("Enter Data ");
        String data[]=new String[n];
        for (int i=0;i<n;i++)
            data[i]=scanner.nextLine();
        handler.input(data);
        System.out.println("THE POINTS ARE "+ handler.points());


    }
}
