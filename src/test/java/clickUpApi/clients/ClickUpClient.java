package clickUpApi.clients;
import clickUpApi.helpers.TestCaseContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;



import static clickUpApi.constants.ProjectConstants.*;

public class ClickUpClient {
    public static Response createFolder(JSONObject obj){
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/space/"+SPACE_ID+"/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }


    public static Response createList(JSONObject obj){

        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/folder/"+TestCaseContext.getTestFolder().getId()+"/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response checkList(){

        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .when()
                .get("https://api.clickup.com/api/v2/list/"+TestCaseContext.getTestList().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }

    public static Response createTask(JSONObject obj){

        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/"+TestCaseContext.getTestList().getId()+"/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }


    public static Response removeTask(){

        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                //.body(obj)
                .when()
                .delete("https://api.clickup.com/api/v2/task/"+TestCaseContext.getTestTask().getId())
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }

    public static Response deleteFolder(){
        return RestAssured
         .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_KEY)
                .when()
                .delete("https://api.clickup.com/api/v2/folder/"+TestCaseContext.getTestFolder().getId())
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }


}
