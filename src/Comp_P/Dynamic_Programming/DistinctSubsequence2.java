package Comp_P.Dynamic_Programming;

/*
Question:
Given a string S, count the number of distinct, non-empty subsequences of S .

Since the result may be large, return the answer modulo 10^9 + 7.


Answer ->

As we know if there is no any duplicate element then answer is 2^n-1
if there is duplicate we will remove all those values appended till previous last same character


Explanation->
for string abc

index 0: result -> "","a"
index 1 : result ->  previous values + previous values with appended charAt(1)
                  -> "","a" + "b","ab"
index 2 : result -> "","a","b","ab"+ "c","ac","bc","abc"
length of index 2 result is 8 but the actual result will be 7 because "" will not be considered


for string aba


index 0: result -> "","a"
index 1 : result ->"","a"+ "b","ab"
index 2 : because it is duplicate value so the result will be now
          result-> ("","a","b","ab" + "a","aa","ba","aba") - result of last a ("","a")
          result -> ("b","ab","a","aa","ba","aba")
 */
class DistinctSubsequenceHandler2
{



}
public class DistinctSubsequence2 {
}
