package Comp_P.GraphBased;
/*

There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?


Approach :- draw Acyclic directed graph to show prerequisite [1,0] 0 -> 1
first choose starting point a node that do not have incoming edge after that traverse all  nodes reachable from this node  only once
after that again choose a node that do not have incoming edge note it must not be traversed before
repeat same process
in the last see if all nodes are traversed if yes return true else return false

 */


import java.util.*;

class CourseScheduleHandler
{
    int courses;
    int pre[][];
    boolean isvisited[];
    HashMap<Integer, ArrayList<Integer>> indexes=new HashMap<Integer,ArrayList<Integer>>();
    HashMap<Integer,ArrayList<Integer>> nodes=new HashMap<>();  // contains that have prerequisite
    Queue<Integer> queue=  new LinkedList();
    void input(int courses,int pre[][])
    {
        this.courses=courses;
        this.pre=pre;
        isvisited=new boolean[courses];
        Arrays.fill(isvisited,false);
    }
    boolean willBeFinished()
    {
        for (int i=0;i<pre.length;i++) {
            if (nodes.containsKey(pre[i][0]))
            {
                nodes.get(pre[i][0]).add(pre[i][1]);
            }
            else {
                ArrayList <Integer> list=new ArrayList<>();
                list.add(pre[i][1]);
                nodes.put(pre[i][0],list);
            }
            if(indexes.containsKey(pre[i][1]))
            {
                indexes.get(pre[i][1]).add(i);
            }
            else
            {
                ArrayList <Integer>set=new ArrayList<>();
                set.add(i);
                indexes.put(pre[i][1],set);
            }
        }
        for (int i=0;i<isvisited.length;i++)
        {
            if (!nodes.containsKey(i))
            {
                queue.add(i);
                while (!queue.isEmpty())
                {
                    int n=queue.poll();
                    isvisited[n]=true;
                    if(indexes.containsKey(n)) {
                        while (indexes.get(n).size() != 0) {
                            int index = indexes.get(n).get(indexes.get(n).size() - 1);
                            indexes.get(n).remove(indexes.get(n).size() - 1);
                            if (!isvisited[pre[index][0]])
                            {


                                boolean flag=true;
                                for(int j=0;j<nodes.get(pre[index][0]).size()-1;j++)
                                {
                                    if (!isvisited[nodes.get(pre[index][0]).get(j)])
                                    {
                                        flag=false;
                                        break;
                                    }
                                }
                                if (flag)
                                queue.add(pre[index][0]);
                            }

                        }
                    }
                }


            }
        }

        for (int i=0;i<courses;i++)
            if (!isvisited[i])
                return false;

        return true;
    }
}
public class CourseSchedulling {


    public static void main(String[] args) {



        CourseScheduleHandler handler=new CourseScheduleHandler();
        System.out.println("Enter Number Of Courses ");
        Scanner scanner=new Scanner(System.in);
        int courses=scanner.nextInt();
        System.out.println("Enter Number Of Courses that have prerequisite ");
        int m=scanner.nextInt();
        int pre[][]=new int[m][2];
        System.out.println("Enter their prerequisite ");
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<2;j++)
            {
                pre[i][j]=scanner.nextInt();
            }
        }
        handler.input(courses,pre);
        System.out.println("Possible to Finish ? "+handler.willBeFinished());
    }
}
