package Comp_P;
import java.util.Scanner;
import java.util.Stack;
/*


You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.


 */
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
