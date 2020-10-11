package Comp_P.Dynamic_Programming;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
In a given array nums of positive integers, find three non-overlapping sub arrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

In this approach i made generic solution for any number of sub-arrays arrays just need to change required value
 */
class MaxSumSubarrayKHandler {
    int data[];
    int allsum[];
    int k;
    void input(int data[], int k) {
        this.data = data;
        this.k = k;
        allsum = new int[data.length - k + 1];
    }

    void allsumFiller() {
        int sum = 0;
        int index = 0;
        int i = 0;
        int j = 0;
        while (j < data.length && i <= j) {
            if (j - i + 1 == k) {
                sum += data[j++];
                allsum[index++] = sum;
                sum -= data[i];
                i++;
            } else {
                sum += data[j++];
            }
        }


    }
    int[] indexgenerator(int index,int required)
    {

        int result[]=new int[required];
        Arrays.fill(result,-1);
        if(Math.floor(data.length/k)<required)
            return result;
        if(required==1)
        {
            int max=Integer.MIN_VALUE;
            int in=-1;
            for(int i=index;i<allsum.length;i++)
            {
                if(max<allsum[i])
                {
                    max=allsum[i];
                    in=i;
                }
            }
            return new int[]{in};
        }
        int max_sum=Integer.MIN_VALUE;
        for (int i=index;i<allsum.length;i++)
        {

            int temp[]=indexgenerator(i+k,required-1);
            if(temp[0]!=-1)
            {
                int sum=allsum[i];
                for (int indices:temp)
                    sum+=allsum[indices];
                if(sum>max_sum)
                {
                    max_sum=sum;
                    if(result[0]!=-1) {
                        if (allsum[i] != allsum[result[0]] || result[0] - i < k)
                            result[0] = i;
                    }
                    else
                        result[0]=i;

                    for (int i1=1;i1<required;i1++)
                    {

                        if(result[i1]!=-1) {
                            if (allsum[temp[i1 - 1]] != allsum[result[i1]] || result[i1] - temp[i1 - 1] < k)
                                result[i1] = temp[i1 - 1];
                        }
                        else
                            result[i1]=temp[i1-1];

                    }

                }
            }
            else
                break;

        }
        return result;
    }


}

class MaxSumSubarrayK {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        MaxSumSubarrayKHandler handler=new MaxSumSubarrayKHandler();
        handler.input(nums,k);
        handler.allsumFiller();
        return  handler.indexgenerator(0,3);
    }
}
