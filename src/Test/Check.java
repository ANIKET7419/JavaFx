package Test;
interface A1
{
    default void hello()
    {
        System.out.println("A1");
    }
}
interface A2 extends A1
{
    default void hello()
    {
        System.out.println("A2");
    }
}
interface A3 extends A2
{
    default void hello()
    {
        System.out.println("A3");
    }
}
interface A4 extends A3
{
    default void hello()
    {
        System.out.println("A4");
    }
}interface A5 extends A4
{
    default void hello()
    {
        System.out.println("A5");
    }
}


class TestClass implements A5
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
