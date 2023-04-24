package dev.ifrs;

import io.quarkus.test.junit.QuarkusTest;

import org.jboss.resteasy.reactive.server.spi.RuntimeConfiguration.Body;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@QuarkusTest
public class ExercicioTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }
    /**
     * 
     */
    @Test
    public void testCupom() {
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
            .body("valor=1150.23&cupom=CUPOM10")
        .when()
            .post("/cupom")
        .then()
             .statusCode(200)
             .body(is("103521"));
    
    }
}