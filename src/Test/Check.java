package Test;

interface a1
{
void hello();
}
interface c1  extends  a1{

}
interface b1 extends c1
{

}
interface a2 extends a1
{

}
interface a3 extends a2
{

}
interface a4 extends a3
{
default void hello()
{
    System.out.println("OKay bro");
}
}

class TestClass implements a4,b1
{
    public  void show()
    {

    }
    public static void main(String args[])
    {
        TestClass d = new TestClass();
        d.show();
    }
}
public class Check {

    public  static void main(String argc[])
    {

    }
}
