package Practice;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.Chronology;

class b
{
static  int m=100;
    b()
    {

        System.out.println("Constructor");
    }
   static  {
        System.out.println("Block Outer");
    }
    {
        System.out.println("Block");
    }
}
public class practice {
    public static void main(String[] args){
     float f=Float.NEGATIVE_INFINITY;
        System.out.println(f);
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        LocalDateTime dat=timestamp.toLocalDateTime();
        System.out.println(dat.getHour());

    }
}
