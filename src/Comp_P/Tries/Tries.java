package Comp_P.Tries;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node
{
        HashMap<Character,Node> childs=new HashMap<>();
}
public class Tries {
    static Node root=new Node();
    static void  insert(String str,int index,Node current)
    {
        if(index>=str.length())
            return;
        boolean flag=true;
        for(Map.Entry<Character,Node> entry:current.childs.entrySet())
        {
            if (entry.getKey()==str.charAt(index))
            {
                flag=false;
                insert(str,index+1,entry.getValue());
                break;
            }
        }
        if(flag)
        {
            Node n=new Node();
            current.childs.put(str.charAt(index),n);
            insert(str,index+1,n);
        }
    }

    static void display(Node root)
    {
        for(Map.Entry<Character,Node> entry:root.childs.entrySet())
        {
           System.out.println(entry.getKey());
           display(entry.getValue());
        }

    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Number of inputs");
        int n=scanner.nextInt();
        for(int i=0;i<n;i++)
        {
            String temp=Integer.toBinaryString(scanner.nextInt());
            for(int j=temp.length();j<=32;j++)
                temp="0" + temp;
            insert(temp,0,root);
        }
        System.out.println();
        display(root);
    }


}
