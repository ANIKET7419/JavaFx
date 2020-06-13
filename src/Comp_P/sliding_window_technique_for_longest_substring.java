package Comp_P;

import java.util.HashSet;
import java.util.Scanner;

class sliding_window_handler
{

    String data;


    public void input(String data)
    {
        this.data=data;
    }
    int[]  main()
    {
        int n=data.length();
        int max=0;
        int start=0,end=0;
        HashSet set=new HashSet();
        for(int i=0,j=0;i<n&j<n;)
        {
            if(set.contains(data.charAt(j)))
            {
                set.remove(data.charAt(i++));
            }
            else
            {
                set.add(data.charAt(j++));
                if(j-i>max)
                {
                   start=i;
                   end=j;
                   max=j-i;
                }
            }
        }
        return new int[]{start,end,max};
    }




}





public class sliding_window_technique_for_longest_substring {


    public static void main(String[] args) {
        sliding_window_handler object=new sliding_window_handler();
        String data;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String");
        data=scanner.nextLine();
        object.input(data);
        int result[]=object.main();
        System.out.println("The Maximum Length is "+result[2]+" And Substring is "+data.substring(result[0],result[1]));
    }
}
