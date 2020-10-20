package Comp_P.Tries;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class MaxXor {

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
    static  long search(@NotNull String binary, int index, Node current) {

        if(binary.length()<=index)
            return 0;
        char chosen = ' ';
        long temp=0;
        if (binary.charAt(index) == '0') {
            Node n1 = current.childs.getOrDefault('1', null);
            if (n1 != null) {
               temp= search(binary, index + 1, current.childs.get('1'));
                chosen = '1';
            } else {
                temp=search(binary, index + 1, current.childs.get('0'));
                chosen = '0';
            }
        } else {
            Node n1 = current.childs.getOrDefault('0', null);
            if (n1 != null) {
                temp=search(binary, index + 1, current.childs.get('0'));
                chosen = '0';
            } else {
                temp=search(binary, index + 1, current.childs.get('1'));
                chosen = '1';
            }
        }

            return (long)((chosen - 48) * Math.pow(2, 31 - index) + temp);
        }


    public static void main(String[] args) {

       HashMap<Integer,String> binary=new HashMap<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Number of inputs");
        int n=scanner.nextInt();
        int data[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int n1=scanner.nextInt();
            data[i]=n1;
            String temp=Integer.toBinaryString(n1);

            for(int j=temp.length();j<=32;j++)
                temp="0" + temp;
            binary.put(n1,temp);
            insert(temp,0,root);
        }
        for(int i:data)
        {
            long result=search(binary.get(i),0,root);
            System.out.println(i+" : "+result);
        }






    }


}
