package Comp_P.Dynamic_Programming;

import java.net.SecureCacheResponse;
import java.util.Scanner;
//Not COrrect at this time
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
            System.out.println(result + result.length());
            return;

        }
        if(position<0)
            return;
        if (target<position)
        {


                speed=-1;
            position+=speed;
            String temp=result;
            result+="RA";
            minimuminstruction(position,speed);
            result=temp;
        }
        else {
            position += speed;
            System.out.println(position);
            speed *= 2;
            String temp = result;
            result += "A";
            minimuminstruction(position, speed);
            result = temp;
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
