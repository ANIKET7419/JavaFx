package Comp_P.Reusable;
public class SegmentTree {

    int data[];
    int treesize=0;
    int result[];
    boolean isbuilt=false;
    void input(int data[])
    {
        this.data=data;
        treesize=2*data.length;
        result=new int[treesize];

    }
    void construct()
    {
        buildTree(0,data.length-1,0);
    }
    private void buildTree(int start,int end,int index) {

        if (start == end) {
            isbuilt=true;
            result[start] = data[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(start, mid, 2 * index + 1);
        buildTree(mid+1, end, 2 * index + 2);
        result[index] = Math.max(result[2 * index + 1], result[2 * index + 2]);
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
        return Integer.max(query(start,mid,2*position+1,querystart,queryend),query(mid+1,end,2*position+2,querystart,queryend));
    }
    int queryMax(int startIndex,int endIndex)
    {
        return query(0,data.length-1,0,startIndex,endIndex);
    }
}
