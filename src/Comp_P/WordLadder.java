package Comp_P;
import com.sun.scenario.effect.impl.state.AccessHelper;
import javafx.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//Under Process
class WordLadderHandler
{
    char start_word[];
    char end_word[];
    boolean istraversed;
    List<String > list;
    void input(@NotNull String start_word, @NotNull String end_word,  List<String>list)
    {
        this.start_word=start_word.toCharArray();
        this.end_word=end_word.toCharArray();
        this.list=list;
    }
    String coversion(@NotNull char data[])
    {
        String temp="";
        for (int i=0;i<data.length;i++)
            temp+=data[i];
        return temp;
    }
    List<String> wildcardMatch()
    {
        //for ()
    }
    int minimum_transformation()
    {
        Queue<String> queue=new LinkedList<>();
        if (!list.contains(coversion(end_word)))
            return 0;
        queue.add(coversion(start_word));
        while (!queue.isEmpty())
        {
            String word=queue.poll();
            for (int i=0;i<word.length();i++) {
                word = word.substring(0,i)+"*"+word.substring(i+1,word.length());
                queue.addAll(wildcardMatch());
            }
        }

    }
}
public class WordLadder {
    public static void main(String[] args) {
        WordLadderHandler handler =new WordLadderHandler();
        System.out.println("Enter Begin Word");
        Scanner scanner=new Scanner( System.in);
        String start_word,end_word;
        start_word=scanner.nextLine();
        System.out.println("Enter Ending Word");
        end_word=scanner.nextLine();
        System.out.println("Enter Word List Length ");
        int length=Integer.parseInt(scanner.nextLine());
        String []list=new String[length];
        System.out.println("Enter Word list data ");
        for (int i=0;i<length;i++)
            list[i]=scanner.nextLine();
        handler.input(start_word,end_word,list);
        System.out.println("The Minimum Transformation is "+handler.minimum_transformation(0,0));
    }
}
