package parallel.org.extension;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RedirectConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * A utility class that extends RestAssured functionality for API testing.
 */
public class RestAssuredExtension {
    private RequestSpecification requestSpec;

    /**
     * Initializes a new instance of the RestAssuredExtension class.
     * It creates a new RequestSpecification with default configurations.
     */
    public RestAssuredExtension() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        requestSpec = builder.build();
    }

    /**
     * Sets the base URI and path for the API requests.
     *
     * @param uri  The base URI to be used for API requests.
     * @param path The base path to be used for API requests.
     */
    public void setUriAndPath(String uri, String path) {
        requestSpec.baseUri(uri);
        requestSpec.basePath(path);
    }

    /**
     * Sends a GET request to the specified URL with the configured request specification.
     *
     * @param url The complete URL to send the GET request.
     * @return A ResponseOptions<Response> object containing the API response.
     */
    public Response getOps(String url) {
        return RestAssured.given().spec(requestSpec).get(url);
    }

    /**
     * Sets whether to follow redirects for the API requests.
     *
     * @param isFollowRedirect A boolean value indicating whether to follow redirects or not.
     */
    public void setFollowRedirect(boolean isFollowRedirect) {
        RedirectConfig redirectConfig = RedirectConfig.redirectConfig().followRedirects(isFollowRedirect);
        requestSpec.config(RestAssured.config().redirect(redirectConfig));
    }
}