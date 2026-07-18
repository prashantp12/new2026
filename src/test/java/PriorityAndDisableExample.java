import org.testng.annotations.Test;

public class PriorityAndDisableExample {

    @Test(priority = 2)
    void OpenWebsite(){
        System.out.println("Open website");
    }

    @Test(priority = 1)
    void Login(){
        System.out.println("Login");
    }

    @Test(enabled = true)
    void AddEntry(){
        System.out.println("Add entry");
    }

    @Test
    void Close(){
        System.out.println("Closed");
    }
}
