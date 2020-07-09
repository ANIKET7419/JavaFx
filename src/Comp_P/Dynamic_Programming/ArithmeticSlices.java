package Comp_P.Dynamic_Programming;
/*
A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of the array A is called arithmetic if the sequence:
A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.



Approach based on sum of 1 ---- n numbers approach




 */

//Under Process

class ArithmeticSlicesHandler
{
    int data[];
 void input(int data[])
 {
     this.data=data;
 }

 int totalSlices()
    {
        if (data.length<3)
            return 0;
        int dp[]=new int[data.length];
        dp[0]=0;
        dp[1]=0;
        int diff=-1;
        if(data[1]-data[0]==data[2]-data[1]) {
            dp[2] = 1;
            diff=data[1]-data[0];
        }
        else
            return 0;
        int start=0;
        for (int i=3;i<data.length;i++)
        {
            if (diff==data[i]-data[i-1])
           dp[i]= i-start-1+dp[i-1];
            else {
               dp[i]=dp[i-1];
               start=i;
            }
        }
        return dp[data.length-1];



    }



}
public class ArithmeticSlices {
}
