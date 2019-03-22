package reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: gws
 * @Date: 2019-03-22 10:06
 * @Description: 动态代理类
 */
public class StudentProxyD implements InvocationHandler {

    Object tar;

    public Object bind(Object tar){
        this.tar = tar;
        return  Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before ..");
        System.out.println(proxy.getClass().getName());
        System.out.println(tar.getClass().getName());
        if (method.getName().equals("speak")) System.out.println("speak method called ..");
        if (method.getName().equals("walk")) System.out.println("walk method called .. ");
        Object r = method.invoke(tar, args);
        System.out.println("after ...");
        return r;
    }

    @Override
    public String toString() {
        return "StudentProxyD{" +
                "tar=" + tar +
                '}';
    }
}
