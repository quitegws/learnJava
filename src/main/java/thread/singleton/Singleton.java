package thread.singleton;

public class Singleton {


}

//立即加载/饿汉式：
//        【在调用方法前，实例就已经被创建】
class Singleton1{
    public static Singleton1 singleton1 = new Singleton1();

    private Singleton1(){}

    public Singleton1 getInstance(){
        // 此代码版本为立即加载
        // 此版本代码的缺点是不能有其他实例变量
        // 因为getInstance()方法没有同步
        // 所以有可能出现非线程安全的问题
        return singleton1;
    }
}
//在JDK1.5之后，双重检查锁定才能够正常达到单例效果
class Singleton2{
    //单例对象在内存中静态共享区中存储
    private static volatile Singleton2 singleton2;

    public Singleton2 getInstance(){
        if (singleton2 == null) {
            synchronized (Singleton2.class){
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}

class SingletonDemo5 {
    private static class SingletonHolder{
        private static final SingletonDemo5 instance = new SingletonDemo5();
    }
    private SingletonDemo5(){}
    public static final SingletonDemo5 getInsatance(){
        return SingletonHolder.instance;
    }
}

enum SingletonDemo6 {
    instance;
    public void whateverMethod(){
    }
}