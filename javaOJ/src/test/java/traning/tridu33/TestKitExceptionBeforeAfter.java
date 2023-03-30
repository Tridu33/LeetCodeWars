package traning.tridu33;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestKitExceptionBeforeAfter {
    @BeforeEach
    public void func1 () {System.out.println("@BeforeEach");}
    @BeforeAll
    public void func2 () {System.out.println("@BeforeAll");}
    @AfterAll
    public void func3 () {System.out.println("@AfterAll");}
    @AfterEach
    public void func4 () {System.out.println("@AfterEach");}
    @Test
    public void test1 () throws InterruptedException {
        test2();
        System.out.println("test1");
        TimeUnit.SECONDS.sleep(3);

    }
    @Test
    public void test2 () {System.out.println("test2");}

}
