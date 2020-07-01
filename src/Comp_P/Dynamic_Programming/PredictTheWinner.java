package Comp_P.Dynamic_Programming;
import java.util.Scanner;
class PredictTheWinnerHandler
{
    int data[];
    boolean bothequal=false;
    void input(int data[])
    {
        this.data=data;
    }
    boolean predict(int i,int j,boolean turn,int firstscore,int secondscore)
    {

        if (i==j)
        {
            if (turn)
            {
                if (firstscore+data[i]>=secondscore)
                {

                    if (firstscore+data[i]==secondscore)
                        bothequal=true;
                    return true;
                }
                else
                    return false;
            }
            else {
                if (secondscore+data[i]>=firstscore)
                {
                    if (secondscore+data[i]==firstscore)
                        bothequal=true;
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        boolean temp1,temp2;
        if (turn) {
            temp1=predict(i + 1, j,!turn,firstscore+data[i],secondscore);
            temp2=predict(i,j-1,!turn,firstscore+data[j],secondscore);

        }
        else {
            temp1=predict(i + 1, j,!turn,firstscore,secondscore+data[i]);
            temp2=predict(i,j-1,!turn,firstscore,secondscore+data[j]);
        }

        if (temp1==false||temp2==false||bothequal)
        {
            return true;
        }
        else return false;
    }

}




public class PredictTheWinner {
    public static void main(String[] args) {
        PredictTheWinnerHandler handler=new PredictTheWinnerHandler();
        System.out.println("Enter the length of the data");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println("Enter Data");
        int data[]=new int[n];
        for (int i=0;i<n;i++)
            data[i]=scanner.nextInt();
        handler.input(data);
       System.out.println("The Result is "+handler.predict(0,data.length-1,true,0,0));
    }
}

/*

------------------DPPPPPPPPPPPPPPPPPPPPPPPP--------------------



public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return winner(nums, 0, nums.length - 1, memo) >= 0;
    }
    public int winner(int[] nums, int s, int e, Integer[][] memo) {
        if (s == e)
            return nums[s];
        if (memo[s][e] != null)
            return memo[s][e];
        int a = nums[s] - winner(nums, s + 1, e, memo);
        int b = nums[e] - winner(nums, s, e - 1, memo);
        memo[s][e] = Math.max(a, b);
        return memo[s][e];
    }
}










 */
