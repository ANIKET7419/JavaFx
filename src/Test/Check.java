package Test;





interface d1
{
    default void hello()
    {
        System.out.println("d1");
    }
}
interface d12 extends d1
{
    default void hello()
    {
        System.out.println("d12");
    }
}
interface d3 extends d12
{

}
interface d4 extends d3
{
    default void hello()
    {
        System.out.println("d4");
    }
}
interface d5 extends d1
{

}
interface d7 extends d5{

}
interface d8 extends d6{

}
interface d6 extends d1
{

}


class TestClass implements d7,d8,d6,d5,d4,d1,d12
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
