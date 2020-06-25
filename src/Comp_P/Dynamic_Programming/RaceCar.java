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
    void minimuminstruction(int position,int speed,boolean called)
    {
        if (position==target)
        {
            System.out.println(result);
            return;

        }
        else if (position<0)
            return;
        if (target<position&&(!called))
        {

            System.out.println("Okay");
            if (speed<0)
                speed=1;
            else
                speed=-1;
            String temp=result;
            result+="R";
            minimuminstruction(position,speed,true);
            result=temp;
        }
        position+=speed;
        System.out.println(position);
           speed*=2;
           String temp=result;
           result+="A";
           if (called==true)
               called=false;
           minimuminstruction(position,speed,called);
           result=temp;



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
        handler.minimuminstruction(0,1,false);
    }
}
