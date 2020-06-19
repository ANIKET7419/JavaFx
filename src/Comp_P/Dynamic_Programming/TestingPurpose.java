package Comp_P.Dynamic_Programming;

import java.util.Arrays;

public class TestingPurpose {


    public static void main(String[] args) {
        int arr[]={1,2,3,5,10};
        int start=0;
        int end=4;
        int index=0;
        while (start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==4)
            {
                index=mid;
                break;
            }
            else if (arr[mid]>4)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        System.out.println(index+ " , "+end+ " , "+start);
    }
}
