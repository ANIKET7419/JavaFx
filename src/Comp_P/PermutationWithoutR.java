package Comp_P;

import java.util.Arrays;
import java.util.Scanner;

class PermutationWithoutRH
{
    String data;
    String result="";
    boolean isvisited[];
    void input(String data)
    {
        this.data=data;
        isvisited=new boolean[data.length()];
        Arrays.fill(isvisited,false);
    }
    void permutation()
    {
        if (result.length()==data.length())
        {
            System.out.println(result);
            return;
        }
        for (int i=0;i<data.length();i++)
        {
            if (!isvisited[i])
            {
                String temp=result;
                result+=data.charAt(i);
                isvisited[i]=true;
                permutation();
                isvisited[i]=false;
                result=temp;
            }
        }
    }


}
public class PermutationWithoutR {


    public static void main(String[] args) {
        PermutationWithoutRH handler =new PermutationWithoutRH();
        String data;
        System.out.println("Enter Data");
        Scanner scanner=new Scanner(System.in);
        data=scanner.nextLine();
        handler.input(data);
        handler.permutation();
    }
}
