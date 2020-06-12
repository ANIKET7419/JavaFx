package Comp_P;
import java.util.*;

class Solution_Set {



    public int[] twoSum(int[] nums, int target) {
        ArrayList data=new ArrayList();
      for(int i=0;i<nums.length;i++)
       {
                data.add(nums[i]);
          }

        for(int i=0;i<nums.length;i++)
        {

            int k=target-nums[i];
            if(data.contains(k))
            {
                return new int[]{i,data.indexOf(k)};
            }


        }

return new int[]{};
    }
}
public class two_sum {



    public static void main(String[] args) {
        Solution_Set set=new Solution_Set();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Size");
        int size=scanner.nextInt();
        System.out.println("Enter Target");
        int target=scanner.nextInt();
        int data[]=new int[size];
        for(int i=0;i<size;i++)
        {
            data[i]=scanner.nextInt();
        }
        int result[]=set.twoSum(data,target);
        if(result.length==0)
        {
            System.out.println("Nothing Found");
        }
        else
        {
            for(int i=0;i<2;i++)
            {
                System.out.println(result[i]);
            }
        }
    }
}
