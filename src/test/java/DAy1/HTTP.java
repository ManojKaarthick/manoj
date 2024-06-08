package DAy1;

import org.testng.annotations.Test;

import javax.annotation.meta.When;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTP {
    int id;
   // @Test
    void getusers() {


        given()

                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))

                .log().all();
    }
    @Test

    void createuser(){
        HashMap data =new HashMap();
        data.put("name","manoj");
        data.put("job","trainer");

       id= given()
                .contentType("application/json")
                .body(data)
                .when()

                 .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

               //.then()
              //  .statusCode(201)
                //.log().all();

    }

    @Test(dependsOnMethods = {"createuser"})

       void updateuser(){

        HashMap data=new HashMap();

        data.put("name","john");
        data.put("job","teacher");

        given()
                .contentType("application/json")
                .body(data)
        .when()
                .put("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(200)
                .log().all();

    }













}
