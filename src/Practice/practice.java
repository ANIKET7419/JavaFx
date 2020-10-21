package Practice;
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
    }
}
