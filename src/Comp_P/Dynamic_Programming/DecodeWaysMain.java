package Comp_P.Dynamic_Programming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class DecodeWays
{
    int totalWays( String data ,int i)
    {
        int total=0;
        if(i==data.length()-1)
            return 1;
        else if(data.charAt(0)=='0')
            return 0;
       /* else if(data.charAt(0)=='0'&&(data.charAt(i-1)!='1'&&data.charAt(i-1)!='2'))
        {
            System.out.println("Decoding Error ----->>>");
            System.out.println("Founding an Error at "+data.charAt(0)+"0");
            System.exit(100);
        }*/
        else
        {

            if(Integer.parseInt(data.substring(0,1))>=1&&Integer.parseInt(data.substring(0,1))<10)
            total=totalWays(data,i+1);
            if(Integer.parseInt(data.substring(0,2))>=10&&Integer.parseInt(data.substring(0,2))<27)
                total+=totalWays(data,i+2);


        }
        return total;
    }
}
public class DecodeWaysMain {

    public static void main(String[] args) {
        DecodeWays decodeWays=new DecodeWays();
        String data;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String");
        data=scanner.nextLine();
        System.out.println("The total Ways are "+decodeWays.totalWays(data,0));
        List l=new ArrayList();
    }
}
