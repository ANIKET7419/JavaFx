package Test;
class a
{
    static int a=1;
    int b=940;
    void hello()
    {
        System.out.println("Hello First ");
    }
    static void op()
    {
        System.out.println("Op second");
    }

}
class b extends a
{
    static int a=2;
    int b=485945;
    void hello()
    {
        System.out.println("Hello second ");
    }
    static void op()
    {
        System.out.println("Op second");
    }
    void unique()
    {
        System.out.println("unique");
    }

}
public class Check2 {
    public static void main(String[] args) {
       a obj=new b();
       obj.hello();
      // obj.unique();
       System.out.println(obj.a);
       System.out.println(obj.b);

    }
}
