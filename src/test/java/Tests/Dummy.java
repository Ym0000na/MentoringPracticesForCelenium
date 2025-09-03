package Tests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.annotations.VisibleForTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dummy {


    @Test
    public void test(){

        int age =11;

        System.out.println(age<18);

        Assertions.assertFalse(age <18);

        String name1 = null;
        String name2 = "John";
        String name3 = "John";
        String name4 = new String("John");

        Assertions.assertNull(name1);
        Assertions.assertNull(name2);

        Assertions.assertNotNull(name1);
        Assertions.assertNotNull(name2);

        assertEquals(name2,name3);
        //assertSame(name2,name3);
        assertEquals(name2,name4);

    }
}
