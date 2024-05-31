

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * The {@code delete} class demonstrates how to make an HTTP DELETE request
 * to a RESTful API using the Java 11 HttpClient.
 */
public class delete {

    /**
     * The main method is the entry point of the Java application. It sends an HTTP DELETE request
     * to a specified API endpoint and prints the response status code and body.
     *
     * @param args Command-line arguments (not used).
     * @throws IOException If an input or output exception occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // Build the HTTP DELETE request
        HttpRequest request = HttpRequest.newBuilder()
            .DELETE()
            .uri(URI.create("https://api.restful-api.dev/objects/ff8081818fb998eb018fc922196e1ed7"))
            .build();

        // Send the HTTP DELETE request and get the response
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // Print the response status code and body
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
