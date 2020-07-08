package Comp_P.Dynamic_Programming;

/*



In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open the door.

Given a string ring, which represents the code engraved on the outer ring and another string key, which represents the keyword needs to be spelled. You need to find the minimum number of steps in order to spell all the characters in the keyword.

Initially, the first character of the ring is aligned at 12:00 direction. You need to spell all the characters in the string key one by one by rotating the ring clockwise or anticlockwise to make each character of the string key aligned at 12:00 direction and then by pressing the center button.

At the stage of rotating the ring to spell the key character key[i]:

You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step. The final purpose of the rotation is to align one of the string ring's characters at the 12:00 direction, where this character must equal to the character key[i].
If the character key[i] has been aligned at the 12:00 direction, you need to press the center button to spell, which also counts as 1 step. After the pressing, you could begin to spell the next character in the key (next stage), otherwise, you've finished all the spelling.
Example:



Input: ring = "godding", key = "gd"
Output: 4
Explanation:
For the first key character 'g', since it is already in place, we just need 1 step to spell this character.
For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
Also, we need 1 more step for spelling.
So the final output is 4.



Approach:->

make a list of all character with their indexes
 for godding

  g-> 0,6
  o-> 1
  d-> 2,3
  i -> 4
  n -> 5
  Now for key gd

  step 1: -> look for whether we have character in table if yes there can be multiple same characters
  for all character find  and return minimum of them because there is also possibility like we are not far away from character but other remaining character are far away from their type so it will affect the minimum steps
  example

  with key g d
           ^
  at 12:00 direction in ring

  g o d d i n g
  ^
  options are character at indices 0,6
  for 0
  the best way to reach is clock wise or anti clock wise need to check
  find
  best distance will be returned

  so on......

 */





class FreedomTrailHandler
{
    String ring,key;
    void input(String ring,String key)
    {
        this.key=key;
        this.ring=ring;
    }
    int minimumSteps(int index1,int index2,boolean clockwise)
    {
        if (clockwise&&index1==key.length()||!clockwise&&index1==-1)
        {
            return 0;
        }
        else
        {
  return 10;
        }
    }


}
public class FreedomTrail {
    public static void main(String[] args) {

    }
}
