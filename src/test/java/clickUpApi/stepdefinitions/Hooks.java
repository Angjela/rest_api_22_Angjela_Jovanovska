package clickUpApi.stepdefinitions;

import clickUpApi.helpers.TestCaseContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import static clickUpApi.clients.ClickUpClient.deleteFolder;

public class Hooks {
    @Before
    public void beforeEveryScenario(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
                System.out.println("SCENARIO STARTED EXECUTION!");
    }

    @After
    public void afterEveryScenario(){
        System.out.println("FOLDER IS DELETED, SO THE TEST CAN BE EXECUTED AGAIN WITHOUT MANUAL REMOVING OF THE FOLDER!");
        deleteFolder();
        // I execute this everytime in the end of scenario because you can't create 2 folders with same name
        System.out.println("SCENARIO IS FINISHED!");
    }
}
