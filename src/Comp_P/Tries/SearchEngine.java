package Comp_P.Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Nodes
{
    int value;
    HashMap<Character,Nodes> childs=new HashMap<>();
}
public class SearchEngine {
    static Nodes root=new Nodes();
    static void  insert(String str,int index,Nodes current,int value)
    {
        if(index>=str.length())
            return;
        boolean flag=true;
        for(Map.Entry<Character,Nodes> entry:current.childs.entrySet())
        {
            if (entry.getKey()==str.charAt(index))
            {
                flag=false;
                insert(str,index+1,entry.getValue(),value);
                break;
            }
        }
        if(flag)
        {
            Nodes n=new Nodes();
            current.childs.put(str.charAt(index),n);
            insert(str,index+1,n,value);
        }
        current.value=Math.max(current.value,value);
    }
    static int highP(String str,int index,Nodes current)
    {
        if(str.length()<=index)
            return 0;
        for(Map.Entry<Character,Nodes> entry:current.childs.entrySet())
        {
            if (entry.getKey()==str.charAt(index))
               return  Math.max(highP(str,index+1,entry.getValue()),current.value);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int testcase = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            insert(str, 0, root, scanner.nextInt());
        }
        for (int i = 0; i < testcase; i++){
            String test=scanner.next();
            System.out.println(highP(test,0,root));
        }
    }

}
