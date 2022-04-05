package clickUpApi.stepdefinitions;

import clickUpApi.domain.Folder;
import clickUpApi.domain.List;
import clickUpApi.domain.Task;
import clickUpApi.helpers.TestCaseContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;

import static clickUpApi.clients.ClickUpClient.*;
import io.restassured.path.json.JsonPath;

public class ClickUpSteps {
    @Given("I create new folder and I check the folder name")
    public void clickUpCreateFolder(){
        JSONObject obj = new JSONObject();
        obj.put("name", "Test Folder");
        Response resp = createFolder(obj);
        Folder defaultFolder = resp.as(Folder.class);
        System.out.println("The folder name is " + defaultFolder.getName());
        Assertions.assertThat(defaultFolder.getName())
                .as("We assert name of the folder ")
                .isEqualTo("Test Folder");

        TestCaseContext.setTestFolder(defaultFolder);
    }

    @When("I create list")
    public static void clickUpCreateList(){
        JSONObject obj = new JSONObject();
        obj.put("name", "Test List");
        Response resp = createList(obj);
        List defaultList = resp.as(List.class);
        TestCaseContext.setTestList(defaultList);
        Assertions.assertThat(defaultList.getName())
                .as("We assert name of the created list ")
                .isEqualTo("Test List");

    }

    @And("I check the list name is {string}")
    public void clickUpCheckListName(String name){
        List testList = TestCaseContext.getTestList();
        Folder testFolder = TestCaseContext.getTestFolder();
        Assertions.assertThat(testList.getName())
                .as("Checking List name!")
                        .isEqualTo("Test List");
        System.out.println("We checked list name is " + name);
        Response resp =  checkList();
        JsonPath j = new JsonPath(resp.asString());
        String p = j.getString("folder.id");
        Assertions.assertThat(TestCaseContext.getTestFolder().getId())
               .as("Checking if it is in right folder!")
                .isEqualTo(p);
        System.out.println("We checked if list " + name +" is in the right folder with id " +TestCaseContext.getTestFolder().getId());
    }

    @Then("I create task")
    public void clickUpCreateTask(){

        JSONObject obj = new JSONObject();
        obj.put("name", "Test Task");
       Response resp = createTask(obj);
        Task defaultTask = resp.as(Task.class);
        TestCaseContext.setTestTask(defaultTask);
        Assertions.assertThat(defaultTask.getName())
                .as("We assert name of the created list ")
                .isEqualTo("Test Task");
    }

    @And("I check the task name is {string}")
    public void checkTaskName(String name){
        Task testTask = TestCaseContext.getTestTask();
        Assertions.assertThat(testTask.getName())
                .as("Checking Task name!")
                .isEqualTo(name);
        System.out.println("We checked task name is " + name);

    }

    @Then("I remove the task {string}")
    public void clickUpRemoveTask(String name){

       Response resp = removeTask();
        System.out.println("The task " + name +" is removed");
    }

    @And("I check task with name {string} can't be found")
    public void checkIfTaskIsRemoved(String name){
        Task testTask = TestCaseContext.getTestTask();
       Response resp = checkList();
        JsonPath j = new JsonPath(resp.asString());
        String p = j.prettyPrint();
        Assertions.assertThat("Test Task")
                .as("Checking if is deleted!")
                .isNotIn(p);
       // System.out.println("HERE I PRINT DATA "+p);
        System.out.println("Check if "+TestCaseContext.getTestTask().getName()+" is removed");
    }



}
