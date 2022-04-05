package clickUpApi.helpers;

import clickUpApi.domain.Folder;
import clickUpApi.domain.List;
import clickUpApi.domain.Task;
import io.cucumber.java.Scenario;

public class TestCaseContext {
    private static Folder testFolder;
    private static List testList;
    private static Task testTask;
    private static Scenario scenario;

    public static void init(){
        testFolder = null;
        testList = null;
        testTask = null;
    }

    public static void setTestFolder(Folder testFolder){
        TestCaseContext.testFolder = testFolder;
    }

    public static Folder getTestFolder(){
        return testFolder;
    }

    public static void setTestList(List testList){
        TestCaseContext.testList = testList;
    }

    public static List getTestList(){
        return testList;
    }

    public static void setTestTask(Task testTask){
        TestCaseContext.testTask = testTask;
    }

    public static Task getTestTask(){
        return testTask;
    }

    public static void setScenario(Scenario scenario){
        TestCaseContext.scenario = scenario;
    }

    public static Scenario getScenario(){
        return scenario;
    }
}
