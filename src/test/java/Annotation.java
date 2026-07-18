import org.testng.annotations.*;

public class Annotation {

    @BeforeSuite
    void beforeSuite(){
        System.out.println("before suite");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("After suite");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("Before test method");
    }

    @AfterTest
    void afterTest() {
        System.out.println("After test method");
    }

    @BeforeClass
    void login() {
        System.out.println("Before class method");
    }

    @BeforeMethod
    void setup() {
        System.out.println("Before method");
    }

    @AfterMethod
    void tearDown() {
        System.out.println("After method");
    }

    @AfterClass
    void logout() {
        System.out.println("After class method");
    }

    @Test
    void test1() {
        System.out.println("First test");
    }

    @Test
    void test2() {
        System.out.println("Second test");
    }

}
