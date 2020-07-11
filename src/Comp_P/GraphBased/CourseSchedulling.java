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
public class CourseSchedulling {
}
