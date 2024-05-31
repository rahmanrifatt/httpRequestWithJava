

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The {@code put} class demonstrates how to make an HTTP PUT request
 * to a RESTful API using a custom object and Jackson for JSON serialization.
 */
public class put {

    /**
     * The main method is the entry point of the Java application. It creates a car object,
     * converts it to a JSON string, and sends it in an HTTP PUT request to a specified API endpoint.
     *
     * @param args Command-line arguments (not used).
     * @throws IOException If an input or output exception occurs.
     */
    public static void main(String[] args) throws IOException {
        // Define car attributes in a HashMap
        HashMap<String, Object> carAttribute = new HashMap<>();
        carAttribute.put("year", 2019);
        carAttribute.put("price", 2000000);
        carAttribute.put("colour", "red");

        // Create the car object
        car car1 = new car("bmw", carAttribute);

        // Convert car object to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(car1);

        // Define the URL to send the PUT request to
        URL url = new URL("https://api.restful-api.dev/objects/ff8081818fb998eb018fc8a09ba51cf5");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        
        // Set up the connection properties
        conn.setRequestMethod("PUT");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        // Send the JSON data in the PUT request body
        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
            dos.writeBytes(requestBody);
        }

        // Print the response code from the server
        System.out.println("Response code: " + conn.getResponseCode());

        // Read and print the response from the server
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
