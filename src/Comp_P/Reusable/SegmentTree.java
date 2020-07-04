package Comp_P.Reusable;
public class SegmentTree {

    int data[];
    int treesize=0;
  public   int result[];

    public  void input(int data[])
    {
        this.data=data;
        treesize=2*data.length;
        result=new int[treesize];

    }
  public   void construct()
    {
        buildTree(0,data.length-1,0);
    }
    int  buildTree(int start,int end,int index) {

        if (start == end) {
            return result[index]=data[start];
        }
        int mid = (start + end) / 2;
       int temp= buildTree(start, mid, 2 * index + 1);
        int temp2=buildTree(mid+1, end, 2 * index + 2);
      return   result[index] = Math.max(temp,temp2);
    }
    private int  query(int start,int end,int position,int querystart,int queryend)
    {
        if (querystart<=start&&queryend>=end)
        {
            return result[position];
        }
        else if (end<querystart||start>queryend)
        {
            return Integer.MIN_VALUE;
        }
        int mid=(start+end)/2;
        return Math.max(query(start,mid,2*position+1,querystart,queryend),query(mid+1,end,2*position+2,querystart,queryend));
    }
 public    int queryMax(int startIndex,int endIndex)
    {
        return query(0,data.length-1,0,startIndex,endIndex);
    }
}
