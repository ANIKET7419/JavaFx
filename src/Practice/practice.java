package Practice;

import java.lang.reflect.Array;
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
     aniket<String> object=new aniket();
         object.set("Heloo");
        System.out.println(object.get());
        HashMap map=new HashMap();
        map.put("aniket","18/94026");
        map.put("rana","18/94029");
        map.put("rana","19/989");
        map.put("nishant","18/94020");
        HashSet set=new HashSet();
        set.add("aniket");
        set.add("rana");
        set.add("g");
        System.out.println(2.0/0);
        if(set.contains("aniket"))
        {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        System.out.println(map.get("rana"));

        hmm op=hmm.Aniket;

        Date date=new Date();
        //Timer timer=new Timer();
        //timer.schedule(new TimerTask() {
          //  @Override
           // public void run() {
             //   System.out.println("hmm");
            //}
        //},0,1000);
        System.out.println(System.getenv("PATH"));
        System.out.println();
        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println(dateTime.getYear());
        System.out.println(Double.NaN);
        new double1().anikeT();
        System.out.println(2.0%0);


        //System.out.println(Calendar.);


        //object.set(100);
        //System.out.println(object.get());
       // helper(object);
        //System.out.println(object.get());

    }
}