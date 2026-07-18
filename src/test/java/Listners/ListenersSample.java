package Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersSample implements ITestListener {

    public void onStart(ITestContext arg0) {
        System.out.println("Listener -- on start method" + arg0.toString());
    }

    public void onFinish(ITestContext arg0){
        System.out.println("Listener -- on finish method" + arg0.toString());
    }

    public void onTestFailure(ITestResult result){
        System.out.println("Listener -- on test failure method" + result.toString());
    }

    public void onTestSkipped(ITestResult arg0){
        System.out.println("Listener -- on test skipped method" + arg0.toString());
    }

    public void onTestStart(ITestResult arg0){
        System.out.println("Listener -- on test start method" + arg0.toString());
    }

    public void onTestSuccess(ITestResult arg0){
        System.out.println("Listener -- on test success method" + arg0.toString());
    }

}
