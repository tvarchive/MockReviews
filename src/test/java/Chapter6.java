import com.jayway.restassured.response.Response;
import entities.Review;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.testng.Assert.assertEquals;

public class Chapter6 extends TestBase {

    final String body = "Palm trees are a botanical family of perennial lianas, shrubs, and trees. " +
            "They are in the family Arecaceae. They grow in hot climates";
    final String author = "Tom";
    final String email = "tom@tv.com";

    @Test
    public void shouldValidateTile() {

        final String title = "";

        Review review = new Review(title, body, author, email);

        Response response = given()
                .request().with()
                    .queryParam("format", "json")
                    .body(review)
                .when()
                    .post("http://localhost:8080/reviews");

        assertEquals(from(response.asString()).get("error"), "_ERROR_TITLE_EMPTY");


    }
}
