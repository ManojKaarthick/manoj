package DAy1;

import java.util.Arrays;
import java.util.HashMap;



import org.testng.annotations.Test;

import javax.annotation.meta.When;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Post {

@Test
    void testpostusinghashmap(){


        HashMap<String,String> data =new HashMap();
        data.put("email","manoj@gmail.com");
        data.put("fname","dinesh");
        data.put("lname","kumar");
        data.put("avatat","kaarthick2@gmail.com");

     String courseArr [] ={"c","c++"};
     data.put("courses", Arrays.toString(courseArr));
        given()

                .contentType("application/json")
                .body(data)

                .when()
                .post("http://localhost:3000/emp")

                .then()
                .statusCode(201)
                .body("fname",equalTo("dinesh"))
                 .body("lname",equalTo("kumar"))
                .log().all();


    }
}
