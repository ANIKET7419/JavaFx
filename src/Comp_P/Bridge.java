package Comp_P;

import java.util.ArrayList;
import java.util.Scanner;
class node
{
    int min=Integer.MAX_VALUE;
    int value;
    int time;
}
public class Bridge {
    static ArrayList<Integer>[] graph;
    static ArrayList<int[]>result;
    static boolean isvisited[];
    static void findBridge(int source) {

        isvisited[source]=true;
        for(int i:graph[source])
        {
            if(!isvisited[i])
            {
                findBridge(i);
            }
            else
            {

            }
        }


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        graph = new ArrayList[n];
        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (graph[a] == null)
                graph[a] = new ArrayList<>();
            if (graph[b] == null)
                graph[b] = new ArrayList<>();
            graph[a].add(b);
            graph[b].add(a);

        }






    }
}