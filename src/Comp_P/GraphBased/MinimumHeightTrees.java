package Comp_P.GraphBased;

import java.util.*;
//Under Process
class TreeHandler
{
    int edges[][];
    int nodes;
    HashMap<Integer, ArrayList<Integer>> connection=new HashMap<>();
    void input(int edges[][],int nodes)
    {
        this.edges=edges;
        for (int i=0;i<edges.length;i++)
        {
            if (connection.containsKey(edges[i][0]))
            connection.get(edges[i][0]).add(edges[i][1]);
            else
            {
                ArrayList <Integer> list=new ArrayList<>();
                list.add(edges[i][1]);
                connection.put(edges[i][0],list);
            }
            if (connection.containsKey(edges[i][1]))
                connection.get(edges[i][1]).add(edges[i][0]);
            else
            {
                ArrayList <Integer> list=new ArrayList<>();
                list.add(edges[i][0]);
                connection.put(edges[i][1],list);
            }
        }
        this.nodes=nodes;
    }
    List<Integer> minimumHeightTrees()
    {
        List<Integer> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
       for (int i=0;i<nodes;i++)
       {
         int temp=height(i);
         if (temp<min)
         {
             list.clear();
         }
         else
         {
             list.add(i);
         }
       }
       return list;
    }
    int height(int root)
    {
        boolean traversed[]=new boolean[nodes];
        Arrays.fill(traversed,false);
        Queue <Integer>queue=new LinkedList();
        int level[]=new int[nodes];
        queue.add(root);
        level[root]=0;
        int height=0;
        while (!queue.isEmpty())
        {
            int node=queue.poll();
          ArrayList <Integer>list=  connection.get(node);
          for (int i:list)
          {
              if (!traversed[i]) {
                  queue.add(i);
                  level[i]=level[node]+1;
              }
          }

        }
        int max=Integer.MIN_VALUE;
     for (int y=0;y<level.length;y++)
     {
         if (max<level[y])
             max=level[y];
     }



        return max;
    }


}
public class MinimumHeightTrees {

}
