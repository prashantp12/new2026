import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsAndAlwaysRuns {

    @Test
    void StartCar() {
        System.out.println("Car is started");
        Assert.fail();
    }

    @Test(dependsOnMethods = "StartCar")
    void RunningCar() {
        System.out.println("Car is running");
    }

    @Test
    void StoppedCar() {
        System.out.println("Car is stopped");
    }

    @Test(dependsOnMethods = {"StartCar", "RunningCar"}, alwaysRun = true)
    void ParkCar() {
        System.out.println("Car is parked");
    }
}
