/*class op{
    public int op111;
       class op1{

    }
}
class op2 extends op{
    private int op111;
   private class op1{

    }

}*/


class Practice
{



    public static void main(String[] args) {
             op2 obj=new op2();
             obj.hello();

    }
}
class op{
    static int op=9450;
}
class op2 extends  op{
    static int op=904;
    void hello()
    {
        System.out.print(this.op);
    }
}