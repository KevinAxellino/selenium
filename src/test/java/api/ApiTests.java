package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ApiTests {

    private static final String BASE_URL = "https://fakerapi.it/api/v1/companies";

    @Test
    public void testDataQuantity() {
        int[] quantities = {20, 5, 1};
        for (int quantity : quantities) {
            Response response = RestAssured.get(BASE_URL + "?_quantity=" + quantity);
            List<?> dataList = response.jsonPath().getList("data");
            Assert.assertEquals(dataList.size(), quantity, "Incorrect data count for quantity: " + quantity);
        }
    }

    @Test
    public void testIdNotNull() {
        Response response = RestAssured.get(BASE_URL);
        List<Integer> ids = response.jsonPath().getList("data.id");
        for (Integer id : ids) {
            Assert.assertNotNull(id, "ID should not be null");
        }
    }

    @Test
    public void testJsonSchemaValidation() {
        Response response = RestAssured.get(BASE_URL);
        File schemaFile = new File("src/test/schema/company_schema.json");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
    }
}
