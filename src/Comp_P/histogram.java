package Comp_P;

import java.util.Scanner;
class stack
{
    int top=-1;
    int data[];
    public stack(int n)
    {
        data=new int[n];
    }
    void push(int value)
    {
        data[++top]=value;
    }
    int pop()
    {
        return data[top--];
    }
    boolean isempty()
    {
        if(top==-1)
        {
            return true;
        }
        else {
            return false;
        }
    }
    int top() {
        if(top==-1)
        {
            return -1;
        }
    return data[top];
    }
}

public class histogram {
    int data[];
void input(int data[])
{
    this.data=data;

}
void max_rectangle()
{
    int max_area=0;
    stack object=new stack(data.length);
    for(int i=0;i<data.length;i++)
    {
        if(!object.isempty())
        {

            while (data[object.top()]>data[i])
            {
                int popedindex=object.pop();
                int top=object.top();
                int area;
                if(top!=-1)
                    area = data[popedindex] * (i - top-1);
                else
                    area=data[popedindex]*(i-1);

               if(area>max_area)
               {
                   max_area=area;
               }
               if(object.top()==-1)
               {
                   break;
               }

            }
            object.push(i);


        }
        else {
            object.push(i);
        }
    }
    while (!object.isempty())
    {
        int popedindex=object.pop();
        int top=object.top();
        int area;
        if(top!=-1)
            area = data[popedindex] * (data.length - top-1);
        else
            area=data[popedindex]*(data.length-1);

        if(area>max_area)
        {
            max_area=area;
        }
    }
    System.out.println("The Maximum Rectangle Area is "+max_area);
}


}
  class Main
{
public static void main(String argc[])
{

    System.out.println("Enter Data Length");
    int n;
    Scanner scanner=new Scanner(System.in);
    n=scanner.nextInt();
    System.out.println("Enter Data");
    int data[]=new int[n];
    for (int i=0;i<n;i++)
    {
        data[i]=scanner.nextInt();
    }
   histogram object=new histogram();
   object.input(data);
   object.max_rectangle();
}
}