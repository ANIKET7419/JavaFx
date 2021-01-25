package Test;
class a
{
    int a=78;
    static int k=890;
    int op=4748;
    void hello1()
    {
        System.out.println("First ");
    }
    static void static_hello()
    {
        System.out.println("Static First");
    }
}
class b extends a
{
    int a=19;
    void hello1()
    {
        System.out.println("Second");
    }
    static void static_hello()
    {
        System.out.println("Static Second");
    }
    void hello()
    {
        System.out.println(super.a);
        System.out.println(this.a);
        super.static_hello();
        this.static_hello();
        super.hello1();
        this.hello1();
        System.out.println(super.k);
        System.out.println(super.op);
        this.k=101;
        this.op=102;
        System.out.println(super.k);
        System.out.println(this.op);

    }
}
public class Check2 {
    public static void main(String[] args) {
        b obj=new b();
        obj.hello();

    }
}
