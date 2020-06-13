package Comp_P;

import java.util.Scanner;

class merging_handler
{
    int first[],second[];
    void input(int first[],int second[])
    {
        this.first=first;
        this.second=second;
    }
    void display()
    {
        for (int i=0;i<first.length;i++)
        {
            System.out.print(first[i]+" , ");
        }
        for (int i=0;i<second.length;i++)
        {
            System.out.print(second[i]+ " , ");
        }
        System.out.println();
    }
    void merging()
    {
        for(int i=0;i<second.length;i++)
        {
                int j=i;
                int key=second[j];
                boolean general_flag=true;
                if(key<second[first.length+j-1])
                    general_flag=false;
                while (j>1-first.length&&general_flag)
                {
                    if(j==0)
                    {
                        first[first.length-1]=second[0];
                    }
                    else if (j>0)
                    {
                        second[j]=second[j-1];
                    }
                    else
                    {
                        first[first.length+j-1]=first[first.length+j];

                    }
                    j--;
                    if(j<0)
                    {
                        first[first.length+j-1]=key;
                        if(key<first[first.length+j-1])
                        {
                            general_flag=true;
                        }
                        else
                        {
                            general_flag=false;
                        }
                    }
                    else
                    {
                        second[j]=key;
                        if(key<second[j-1])
                        {
                            general_flag=true;
                        }
                        else
                        {
                            general_flag=false;
                        }

                    }

                }


        }
    }
}




public class merging_withoutextraspace {
    public static void main(String[] args) {
        merging_handler handler=new merging_handler();
        int m,n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Size of first Array");
        m=scanner.nextInt();
        System.out.println("Enter Size of Second Array");
        n=scanner.nextInt();
        int first[]=new int[m];
        int second[]=new int[n];
        System.out.println("Enter Data Of First Array");
        for(int i=0;i<m;i++)
        {
            first[i]=scanner.nextInt();
        }
        System.out.println("Enter Data Of Second Array");
        for(int i=0;i<n;i++)
        {
            second[i]=scanner.nextInt();
        }
        handler.input(first,second);
        System.out.println("Result After Merging");
        handler.display();
    }
}
