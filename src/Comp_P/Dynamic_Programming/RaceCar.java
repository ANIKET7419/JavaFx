package Comp_P.Dynamic_Programming;

import java.net.SecureCacheResponse;
import java.util.Scanner;

class RaceCarHandler
{
    int target;
    String result="";
    void input(int target)
    {
        this.target=target;
    }
    void minimuminstruction(int position,int speed)
    {
        if (position==target)
        {
            System.out.println(result);
            return;

        }
        else if (position<0)
            return;
        if (target>position)
        {
            if (speed<0)
                speed=1;
            else
                speed=-1;
            String temp=result;
            result+="R";
            minimuminstruction(position,speed);
            result=temp;
        }
        if (position<target || position>target)
        {
           position+=speed;
           speed*=2;
           String temp=result;
           result+="A";
           minimuminstruction(position,speed);
           result=temp;
        }


    }
}
public class RaceCar {
    public static void main(String[] args) {
        RaceCarHandler handler=new RaceCarHandler();
        int n;
        System.out.println("Enter The Target ");
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        handler.input(n);
        handler.minimuminstruction(0,1);
    }
}
