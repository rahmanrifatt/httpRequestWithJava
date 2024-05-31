import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class demonstrates how to make an HTTP GET request to a RESTful API and
 * process the response.
 */
public class get {

    /**
     * The main method is the entry point of the Java application. It makes an
     * HTTP GET request to a specified API endpoint and prints the response.
     *
     * @param args Command-line arguments (not used).
     * @throws IOException If an input or output exception occurs.
     */
    public static void main(String[] args) throws IOException {
        // Create a URL object with the API endpoint
        URL urlObj = new URL("https://api.restful-api.dev/objects");
        
        // Open a connection to the URL and cast it to HttpsURLConnection
        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
        
        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Get the response code from the server
        int responseCode = connection.getResponseCode();

        // Check if the response code is HTTP OK (200)
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Create a BufferedReader to read the response from the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            
            // Read the response line by line and append it to the StringBuilder
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            
            // Close the BufferedReader
            reader.close();
            
            // Print the response
            System.out.println("Response: " + response.toString());
        } else {
            // Print an error message if the response code is not HTTP OK
            System.out.println("Error: " + responseCode);
        }
        
        // Disconnect the connection
        connection.disconnect();
    }
}
