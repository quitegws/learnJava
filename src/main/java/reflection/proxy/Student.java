package reflection.proxy;

/**
 * @Author: gws
 * @Date: 2019-03-22 10:03
 * @Description:
 */
public class Student implements People {


    @Override
    public void speak() {
        System.out.println("student speak gently ...");
    }

    @Override
    public void walk() {
        System.out.println("student walk quickly ...");
    }

    @Override
    public String toString() {
        return "Student{}";
    }
}
