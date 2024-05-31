

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The {@code patch} class demonstrates how to make an HTTP PATCH request
 * to a RESTful API using a custom object and Jackson for JSON serialization.
 */
public class patch {

    /**
     * The main method is the entry point of the Java application. It creates a car object,
     * converts it to a JSON string, and sends it in an HTTP PATCH request to a specified API endpoint.
     *
     * @param args Command-line arguments (not used).
     * @throws IOException If an input or output exception occurs.
     * @throws InterruptedException If the operation is interrupted.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // Define the URL to send the PATCH request to
        String url = "https://api.restful-api.dev/objects/ff8081818fb998eb018fce76af18282c";
        
        // Create the car object and set its name
        car car1 = new car();
        car1.setName("dhaka");

        // Convert car object to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(car1);

        // Build the HTTP PATCH request
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
            .build();

        // Send the HTTP PATCH request and get the response
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // Print the response status code and body
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
