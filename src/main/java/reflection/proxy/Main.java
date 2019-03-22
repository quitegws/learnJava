package reflection.proxy;

/**
 * @Author: gws
 * @Date: 2019-03-22 10:04
 * @Description:
 */
public class Main {


    public static void main(String[] args) {

        //静态代理
//        proxyS();
        //动态代理
        proxyD();
    }

    public static void proxyS(){
        People student = new Student();
        StudentProxyS proxyS = new StudentProxyS(student);
        proxyS.speak();
        proxyS.walk();
    }

    public static void proxyD(){
        People student = new Student();
        StudentProxyD proxy = new StudentProxyD();
        People pr = (People) proxy.bind(student);

        pr.walk();

        pr.speak();
    }
}
