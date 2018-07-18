package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: gws
 * @Date: 17/07/2018 00:34
 * @Description:
 */
public class DemoReflection {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Demo d = new Demo();

        Field field2 = d.getClass().getField("field2");
        System.out.println(field2.getType());

        Constructor<? extends Demo> constructor = d.getClass().getConstructor();
    }
}
class Demo{
    private int field1 = 0;
    public String field2 = "s";
    public Demo(){

    }

    public int method(){
        return 0;
    }

    public void method2(){
        System.out.println("method2 called");
    }
}