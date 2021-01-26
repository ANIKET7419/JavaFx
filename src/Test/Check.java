package Test;
interface  A2
{
     default void hello()
    {
        System.out.println("CLASS");
    }
}


 interface A1 extends A2
{

    default void hello()
    {
        System.out.println("INTERFACE ");
    }
}
interface A3 extends A1{

}

class TestClass implements A3,A2
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
