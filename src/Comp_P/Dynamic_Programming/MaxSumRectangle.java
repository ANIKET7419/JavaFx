package Comp_P.Dynamic_Programming;

import java.util.TreeSet;

/*

Best Approach:-> (FOR 1-D ARRAY TO FIND MAXIMUM SUM CONTIGUOUS NOT LARGER THAN K)
Efficient Approach: Sum of sub array [i, j] is given by cumulative sum till j – cumulative sum till i of array. Now the problem reduces to finding two indexes i and j such that i < j and cum[j] – cum[i] are as close to K but lesser than it.

To solve this, iterate the array from left to right. Put the cumulative sum of i values that you have encountered till now into a set. When you are processing cum[j] what you need to retrieve from the set is the smallest number in the set which is bigger than cum[j] – K. This can be done in O(logN) using upper_bound on the set.


I will not  use Kadane's Algorithm for an array to find out contiguous maximum sum less than or equal to k
Because kadane in some cases give wrong answer when we choose a value as starting point but it addition with some value gives us right answer
And from row 0 to number_rows-1 index i will apply sub-matrix technique to figure out maximum sum in
sub matrix not larger than k
 */
class MaxSumHandler
{
    int matrix[][];
    int k;
    void input(int matrix[][],int k)
    {
        this.matrix=matrix;
        this.k=k;
    }
    int solver()
    {

        int result=Integer.MIN_VALUE;
        for (int i=0;i<matrix[0].length;i++)
        {
            int temp[]=new int[matrix.length];
            for (int j=i;j<matrix[0].length;j++)
            {
                for (int k=0;k<matrix.length;k++)
                    temp[k]+=matrix[k][j];
                result=Math.max(cumulative_subarray_sum(temp),result);
            }
        }
        return result;
    }
    int cumulative_subarray_sum( int data[])
    {
        TreeSet <Integer>set=new TreeSet();
        set.add(0);
        int cum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<data.length;i++ )
        {
            cum+=data[i];
            Integer temp=set.ceiling(cum-k);
            if(temp!=null)
                max= Math.max(cum-temp,max);
            set.add(cum);

        }
        return max;
    }

}


public class MaxSumRectangle {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        MaxSumHandler handler=new MaxSumHandler();
        handler.input(matrix,k);
        return handler.solver();
    }
}
