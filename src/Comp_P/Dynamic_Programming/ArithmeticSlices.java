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

import java.util.Arrays;

class ArithmeticSlicesHandler
{
    int data[];
    int storage[][];
    int counter=0;
    void input(int data[])
    {
        this.data=data;
        storage=new int[data.length][data.length];
        for(int temp[]:storage)
            Arrays.fill(temp,-1);
    }
    boolean isArithmetic(int i,int j)
    {

        int diff=data[i+1]-data[i];
        for (int k=i+2;k<=j;k++)
        {
            if(data[k]-data[k-1]!=diff)
                return false;
        }
        return true;
    }
    int totalSlices(int i,int j)
    {

        if(j-i+1<=2)
            return 0;
        if(storage[i][j]!=-1)
        {
            counter++;
            return storage[i][j];
        }
        if(isArithmetic(i,j))
        {
            int n=j-i+1;
            return storage[i][j]=((n*(n+1))/2)-n-(n-2+1);
        }
        int max=Integer.MIN_VALUE;
        for (int k=i;k<j;k++)
        {
            int t=totalSlices(i,k)+totalSlices(k+1,j);
            max=Math.max(max,t);
        }
        return storage[i][j]=max;
    }



}
class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        ArithmeticSlicesHandler handler =new ArithmeticSlicesHandler();
        handler.input(A);
        int result=handler.totalSlices(0,A.length-1);
        System.out.println(handler.counter);
        return result;
    }
}
/*
Other simple solution



 */