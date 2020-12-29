import java.util.HashSet;
import java.util.Scanner;

public class UniqueAllCombinations {

    static HashSet<String> resultSet=new HashSet<>();
    static String result="";

    static void combinations(int index,String input)
    {

        if (index>=input.length())
        {
            resultSet.add(result);
            return;
        }
        String temp=result;
        result+=input.charAt(index);
        combinations(index+1,input);
        result=temp;
        combinations(index+1,input);
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter String ");
        String input=scanner.nextLine();
        combinations(0,input);
        System.out.println(resultSet);
        System.out.println(resultSet.size());
    }
}
