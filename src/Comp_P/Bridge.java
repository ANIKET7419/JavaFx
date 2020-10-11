package Comp_P;

import java.util.ArrayList;
import java.util.Scanner;
class Node
{
    int min;
    int value;
}
public class Bridge {
    static ArrayList<Node>[] graph;
    static ArrayList<int[]>result;
    static boolean isvisited[];
    static Node nodes[];
    static int time=0;
    static void findBridge(int source,int parent) {
        isvisited[source]=true;
        nodes[source].min=time++;
        for(Node i:graph[source])
        {
            if(!isvisited[i.value])
                findBridge(i.value,source);
        }
        for(Node i:graph[source]) {
            if(parent!=-1&&nodes[parent].value!=i.value)
            nodes[source].min = Math.min(nodes[source].min, i.min);
        }
        if(parent!=-1&&nodes[parent].min<nodes[source].min)
            result.add(new int[]{source,parent});
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        graph = new ArrayList[n];
       nodes=new Node[n];
        for(int i=0;i<n;i++) {
            nodes[i] = new Node();
            nodes[i].value=i;
        }
        for (int i = 0; i < e; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (graph[a] == null)
                graph[a] = new ArrayList<>();
            if (graph[b] == null)
                graph[b] = new ArrayList<>();

            graph[a].add(nodes[b]);
            graph[b].add(nodes[a]);
        }
        isvisited=new boolean[n];
        findBridge(0,-1);
        System.out.println("Bridges Are : : -> ");
        System.out.println(result);

    }
}