import org.testng.annotations.Test;

public class GroupsExample {

    @Test(groups = {"smoke"})
    void test1() {
        System.out.println("First test");
    }

    @Test(groups = {"smoke"})
    void test2() {
        System.out.println("Second test");
    }

    @Test(groups = {"sanity"})
    void test3() {
        System.out.println("Third test");
    }

    @Test(groups = {"smoke", "sanity"})
    void test4() {
        System.out.println("Fourth test");
    }
}
