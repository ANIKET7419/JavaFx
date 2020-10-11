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
        /*{
            System.out.println("Main");
        }
        {
            System.out.println("Main 2");
        }
       // b obj=new b();
        //b obj2=new b();
        b.m=190;
        {
            System.out.println("Main 3");
        }*/
    }
}