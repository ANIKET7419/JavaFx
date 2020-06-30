package Practice;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;

class aniket<T extends String>
{
    T l;
    T get()
    {
        return l;
    }
    void set(T op)
    {
        l=op;
    }
}
enum hmm
{
    Aniket,Rana,G;
}
 class double1
        {
           double  y;
           String l;
            void anikeT()
            {
                String kl;
                System.out.println(y);
                System.out.println(l);


            }
        }
public class practice {



   /* public static <T extends String> void helper(@NotNull aniket <T> lo) {
        lo.set((T)"help");

    }*/


    public static void main(String[] args) {
      Integer array[][]=new Integer[10][10];
      for (Integer  v[]:array)
          for (Integer v1:v)
          System.out.println(v1);



    }
}