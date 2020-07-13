package Comp_P;
import java.util.Scanner;

class WordLadderHandler
{
    char start_word[];
    char end_word[];
    String  list[];
    void input(String start_word,String end_word,String list[])
    {
        this.start_word=start_word.toCharArray();
        this.end_word=end_word.toCharArray();
        this.list=list;
    }
    int search(char data[],int index)
    {
        String word=data.toString();
        for (int o=index;o<list.length;o++)
            if (word.equals(list[o]))
                return o;
            return -1;
    }
    int minimum_transformation(int list_index,int depth)
    {

        if (list_index>=list.length)
            return 0;
        if (list[list_index].equals(end_word))
            return depth;
        int result=Integer.MAX_VALUE;
        for (int i=0;i<start_word.length;i++)
        {
            if (start_word[i]!=end_word[i])
            {
                start_word[i]=end_word[i];
                int index=search(start_word,list_index+1);
                if (index!=-1)
                {
                    int temp=minimum_transformation(index,depth+1);
                    if (temp!=0)
                        result=Math.min(result,temp);
                }
            }

        }
        return result==Integer.MAX_VALUE?0:result;
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
