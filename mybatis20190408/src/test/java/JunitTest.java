import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitTest {

    @Before
    public void before(){
        System.out.println("测试之前");
    }

    @After
    public void after(){
        System.out.println("测试之后");
    }



    @Test
    public void print(){
        System.out.println("谁睡着了？");
    }

    @Test
//    当有两个test的时候 选中其中一个执行
    public void print02(){
        System.out.println("今天天气很冷");
    }
}
