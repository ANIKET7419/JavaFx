
/*class io {




         class Okay1 {
             private Okay1(){

             }
             private int i=10;
            }

            public void main1(String[] args) {
                Okay1 op=new Okay1();
                op.i=190;


            }

    }
*/


class A{
    int x=490;
    class B{
        int x=68595;

        public void main() {
            System.out.println(A.this.x);
            class D{
                int x=3;
                public void main(){
                    System.out.println(A.this.x);
                    System.out.println(B.this.x);
                    System.out.println(D.this.x);
                    System.out.println(x);
                }
            }
            System.out.println(B.this.x);
            System.out.println(x);
            D op=new D();
            op.main();
        }

    }

    public static  void main(String[] args) {
        A op=new A();
        A.B op1=op.new B();
        op1.main();
    }
}