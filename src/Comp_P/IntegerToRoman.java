package Comp_P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class ITRHandler
{
    int integer;
    String result="";
    void  input(int integer)
    {
        this.integer=integer;
    }
    void converstion()
    {
        int divider=10;
        int previous=-1;
        ArrayList <Integer>list=new ArrayList();
        while (true)
        {

            if (previous==-1) {
                previous = integer % divider;
                if (previous!=0)
                list.add(previous);
                if(previous==integer)
                    break;

            }
            else
            {
                int temp=integer%divider;
                int temp1=temp-previous;
                if(temp1!=0)
                list.add(temp1);
                previous=temp;
                if (temp==integer)
                    break;

            }

            divider*=10;
        }
        for (int i=list.size()-1;i>=0;i--)
        {
            int value=list.get(i);
            if(value>=1000)
            {
                int times=value/1000;
                for (int j=0;j<times;j++)
                    result+='M';
            }
            else if (value==50)
            {
             result+='L';
            }
            else if(value==10)
            {
                result+='X';
            }
            else if(value==5)
            {
                result+='V';
            }
            else if (value==1)
                result+='I';
            else if(value==500)
            {
                result+='D';
            }
            else if(value==100)
            {
                result+='C';
            }
            else if(value==400)
            {
                result+="CD";
            }
            else if(value==40)
            {
                result+="XL";

            }
            else if (value==4)
            {
                result+="IV";
            }
            else if (value==9)
            {
                result+="IX";
            }
            else if (value==90)
            {
                result+="XC";
            }
            else if(value==900)
            {
                result+="CM";
            }
            else if(value<500&&value>100)
            {
                int times=value/100;
                for (int j=0;j<times;j++)
                    result+='C';
            }
            else if(value>10&&value<50)
            {
                int times=value/10;
                for (int j=0;j<times;j++)
                    result+='X';
            }
            else if (value>1&&value<5)
            {
                for (int j=0;j<value;j++)
                result+='I';
            }
            else if (value>50&&value<100)
            {
                int times=(value-50)/10;
                result+='L';
                for (int j=0;j<times;j++)
                    result+='X';
            }
            else if (value>500&&value<1000)
            {
                int times=(value-500)/100;
                result+='D';
                for (int j=0;j<times;j++)
                    result+='C';
            }
            else if (value>5&&value<10)
            {
                int times=(value-5);
                result+='V';
                for (int j=0;j<times;j++)
                    result+='C';
            }


        }
    }


}
public class IntegerToRoman {
    public static void main(String[] args) {
        int integer;
        System.out.println("Enter Integer");
        Scanner scanner=new Scanner(System.in);
        integer=scanner.nextInt();
        ITRHandler handler=new ITRHandler();
        handler.input(integer);
        handler.converstion();
        System.out.println("The Result is "+handler.result);

    }
}
