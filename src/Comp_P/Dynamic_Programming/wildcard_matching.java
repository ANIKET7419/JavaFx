package Comp_P.Dynamic_Programming;

import java.util.Scanner;

class handler
{
    String data;
    String pattern;
    byte storage[][];
    void input(String data,String pattern)
    {
        this.data=data;
        this.pattern=pattern;
        storage=new byte[this.pattern.length()+1][this.data.length()+1];
        for (int i=0;i<this.pattern.length()+1;i++)
        {
            for (int j=0;j<this.data.length()+1;j++)
            {
                storage[i][j]=-1;
            }
        }
    }
    boolean ismatched(int i,int j) {
        if(storage[i][j]!=-1)
        {
            if(storage[i][j]==1)
                return true;
            else
                return false;
        }
        if (i == 0 || j == 0) {
            if (i == 0 && j == 0) {
                storage[i][j]=1;
                return true;
            }
            else {
                if (i == 0) {
                    storage[i][j]=0;
                    return false;
                }
                else {
                    if (pattern.charAt(i - 1) == '*') {
                       if(ismatched(i-1,j))
                       {
                           storage[i][j]=1;
                           return true;
                       }
                       else
                       {
                           storage[i][j]=0;
                           return false;
                       }
                    }
                }
            }
        } else {
            if (pattern.charAt(i - 1) != '*' && pattern.charAt(i - 1) != '?') {
                if (data.charAt(j - 1) == pattern.charAt(i - 1)) {
                    if(ismatched(i-1,j-1))
                    {
                        storage[i][j]=1;
                        return true;
                    }
                    else
                    {
                        storage[i][j]=0;
                        return false;
                    }
                } else {
                    storage[i][j]=0;
                    return false;
                }
            } else {
                if (pattern.charAt(i - 1) == '?') {
                    if(ismatched(i-1,j-1))
                    {
                        storage[i][j]=1;
                        return true;
                    }
                    else
                    {
                        storage[i][j]=0;
                        return false;
                    }
                } else {

                    if( ismatched(i - 1, j) || ismatched(i, j - 1))
                    {
                        storage[i][j]=1;
                        return true;
                    }
                    else
                    {
                        storage[i][j]=0;
                        return false;
                    }
                }


            }

        }
        return false;
    }

}
public class wildcard_matching {


    public static void main(String[] args) {
        handler object=new handler();
        String data;
        String pattern;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String");
        data=scanner.nextLine();
        System.out.println("Enter Pattern");
        pattern=scanner.nextLine();
        object.input(data,pattern);
        System.out.println("Valid or Not "+object.ismatched(pattern.length(),data.length()));
    }
}
