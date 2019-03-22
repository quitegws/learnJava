package reflection.proxy;

/**
 * @Author: gws
 * @Date: 2019-03-22 11:53
 * @Description:
 */
public class StudentProxyS implements People{

    People people;

    public StudentProxyS(People people) {
        this.people = people;
    }

    @Override
    public void speak() {
        System.out.println("before static proxy ...");
        people.speak();
        System.out.println("after static proxy ... ");
    }

    @Override
    public void walk() {
        System.out.println("before static proxy ... ");
        people.walk();
        System.out.println("after static proxy");
    }
}
