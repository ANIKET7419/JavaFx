package Test;

interface d1
{
    default void hello()
    {
        System.out.println("OP2");
    }
}
interface a1 extends d1
{
    default void hello()
    {
        System.out.println("OP");
    }
}
interface c1 extends a1{

}
interface d2 extends c1{

}
interface b extends d1
{
}
class TestClass implements d2,b
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
