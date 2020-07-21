package Comp_P.Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashMap;
//Under Progress
public class ArithmeticSlice2 {
    int data[];
    void input(int data[])
    {
        this.data=data;
    }
    int totalsubsequence()
    {
        HashMap<Integer, HashMap<Integer,ArrayList<Integer>>> map=new HashMap<>();
        for (int i=0;i<data.length;i++)
        {
            for (int j=i+1;j<data.length;j++)
            {
                if (!map.containsKey(data[j]-data[i]))
                {
                    HashMap<Integer,ArrayList<Integer>> list=new HashMap<>();
                    if (!map.containsKey(data[i]))
                    {
                        ArrayList list1=new ArrayList();
                        list1.add(data[i]);
                        list1.add(data[j]);
                        list.put(data[i],list1);
                    }
                    else
                    {

                        list.get(data[i]).add(data[j]);

                    }
                }
                else {
                    HashMap<Integer,ArrayList<Integer>> list=map.get(data[j] - data[i]);
                    if(!list.containsKey(data[i]))
                    {
                        ArrayList list1=new ArrayList();
                        list1.add(data[i]);
                        list1.add(data[j]);
                        list.put(data[i],list1);
                    }
                    else
                    {
                        list.get(data[i]).add(data[j]);
                    }
                }
            }
        }





      System.out.println(map);
        return 0;



    }


}
