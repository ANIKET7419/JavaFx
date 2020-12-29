package Comp_P;

import java.util.Scanner;

public class RoatateImage {



   static public void rotateImage(int matrix[][])
    {
        for(int i=0;i<matrix.length;i++)
        transpose(matrix,i);


        //Reverse

        for(int i=0;i<matrix.length/2;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                int temp=matrix[j][matrix.length-1-i];
                matrix[j][matrix.length-1-i]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    }
    static void transpose(int matrix[][],int i)
    {
        for(int k=i;k<matrix.length;k++)
        {
            int temp=matrix[i][k];
            matrix[i][k]=matrix[k][i];
            matrix[k][i]=temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Value of n");
        int n=scanner.nextInt();
        System.out.println("Enter Data");
        int matrix[][]=new int [n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                matrix[i][j]=scanner.nextInt();
            rotateImage(matrix);
            System.out.println("After Rotation : ");
            for(int arr[]:matrix)
            {
                for (int val:arr)
                {
                    System.out.print(val+" ");
                }
                System.out.println();
            }
    }




}
