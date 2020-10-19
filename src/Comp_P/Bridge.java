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
            if(parent==-1)
            nodes[source].min = Math.min(nodes[source].min, i.min);
            else if (parent!=i.value)
                nodes[source].min=Math.min(nodes[source].min,i.min);
        }
        if(parent!=-1&&nodes[parent].min<nodes[source].min)
            result.add(new int[]{source,parent});
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number Of Nodes");
        int n = scanner.nextInt();
        System.out.println("Enter Number of Edges");
        int e = scanner.nextInt();
        graph = new ArrayList[n];
       nodes=new Node[n];
        for(int i=0;i<n;i++) {
            nodes[i] = new Node();
            nodes[i].value=i;
        }
        System.out.println("Enter Edges ");
        for (int i = 0; i < e; i++) {
            String temp=scanner.next();
            String ui[]=temp.split(",");
            int a = Integer.parseInt(ui[0]);
            int b =Integer.parseInt(ui[1]);
            if (graph[a] == null)
                graph[a] = new ArrayList<>();
            if (graph[b] == null)
                graph[b] = new ArrayList<>();

            graph[a].add(nodes[b]);
            graph[b].add(nodes[a]);
        }
        result=new ArrayList<>();
        isvisited=new boolean[n];
        findBridge(0,-1);
        System.out.println("Bridges Are : : -> ");
        for(int []temp:result)
        System.out.println(temp[0]+" , "+temp[1]);

    }
}