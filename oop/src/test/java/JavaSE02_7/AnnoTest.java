package JavaSE02_7;

import JavaSE02_6.Submarine;
import org.junit.Test;

public class AnnoTest {

    @Test
    public void annoTest(){
       if (Submarine.class.isAnnotationPresent(MyAnno.class))
           System.out.println(Submarine.class.getAnnotations()[0].toString());
        else System.out.println("no");
    }
}
