package singleton.lanhan;

public class InrSClassTest {

    public static void main(String[] args) {
        //单独执行这个，发现没有调用构造方法
        InrStaticClass.printA();

      new Thread(new Runnable() {
          @Override
          public void run() {
              InrStaticClass isc=  InrStaticClass.getInstance();
              System.out.println(isc);
          }
      }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                InrStaticClass isc=  InrStaticClass.getInstance();
                System.out.println(isc);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                InrStaticClass isc=  InrStaticClass.getInstance();
                System.out.println(isc);
            }
        }).start();

    }
}
