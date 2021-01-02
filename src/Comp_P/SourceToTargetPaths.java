package Comp_P;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SourceToTargetPaths {
   static  ArrayList<Integer> temp_result=new ArrayList<>();
   static ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
   static public void dfs(int graph[][],int current)
    {
        if (current==graph.length-1)
        {
            paths.add((ArrayList<Integer>) temp_result.clone());
            return;

        }
        for (int i:graph[current]) {
            temp_result.add(i);
            dfs(graph, i);
            temp_result.remove(temp_result.size()-1);
        }

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of vertices ");
        int n=scanner.nextInt();
        System.out.println("Enter all connected vertex for each vertex ");
        int[][] graph =new int[n][];
        for (int i=0;i<n;i++)
        {
            System.out.println("Enter Number of connected vertices to vertex "+i);
            int m=scanner.nextInt();
            if (m!=0)
            System.out.println("Enter Vertices");
            graph[i]=new int[m];
            for (int j=0;j<m;j++)
                graph[i][j]=scanner.nextInt();
        }
        temp_result.add(0);
        dfs(graph,0);
        System.out.println("All Paths : ");
        System.out.println(paths);

    }
}
