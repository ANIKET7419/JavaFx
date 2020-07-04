package Comp_P.Reusable;
public class SegmentTree {

    int data[];
    int result[][];
    public  void input(int data[])
    {
        this.data=data;
        result=new int[ 2*data.length][2];

    }
  public   void construct()
    {
        buildTree(0,data.length-1,0);
    }
    int []  buildTree(int start,int end,int index) {

        if (start == end) {
             result[index][0]=data[start];
             result[index][1]=start;
             return result[index];
        }
        int mid = (start + end) / 2;
       int temp[]= buildTree(start, mid, 2 * index + 1);
        int temp2[]=buildTree(mid+1, end, 2 * index + 2);
         result[index][0] = Math.max(temp[0],temp2[0]);
         result[index][1]=temp[0]>temp2[0]?temp[1]:temp2[1];
         return result[index];
    }
    private int[]  query(int start,int end,int position,int querystart,int queryend)
    {
        if (querystart<=start&&queryend>=end)
        {
            return result[position];
        }
        else if (end<querystart||start>queryend)
        {
            return new int[]{Integer.MIN_VALUE,-1};
        }
        int mid=(start+end)/2;
        int temp1[]=query(start,mid,2*position+1,querystart,queryend);
        int temp2[]=query(mid+1,end,2*position+2,querystart,queryend);
        int value=  Math.max(temp1[0],temp2[0]);
        int index=temp1[0]>temp2[0]?temp1[1]:temp2[1];
        return new int[]{value,index};
    }
 public    int[] queryMax(int startIndex,int endIndex)
    {
        return query(0,data.length-1,0,startIndex,endIndex);
    }
}
