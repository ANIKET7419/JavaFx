package Test;
interface  A2 extends A1
{
     default void hello()
    {
        System.out.println("CLASS");
    }
}


 interface A1
{

    default void hello()
    {
        System.out.println("INTERFACE ");
    }
}

class TestClass implements A1,A2
{
    public static void main(String args[])
    {
        new TestClass().hello();
    }
}
public class Check {

    public  static void main(String argc[])
    {

    }
}
