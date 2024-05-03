
package threads;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateRunStatus {

    public static void stop(int run) {
        try {
            // Create the URL object with the endpoint
            URL url = new URL("http://192.168.101.122:8080/rest/legoservice/setrun");

            // Create HttpURLConnection object
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            conn.setRequestMethod("POST");

            // Set request headers
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            // Enable output and disable caching
            conn.setDoOutput(true);
            conn.setUseCaches(false);

            // Create JSON payload
            String payload =  "{\"run\": " + run + "}";

            // Get the output stream from the connection
            try (OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }

            // Get the response code
            int responseCode = conn.getResponseCode();

            // Check if request was successful (HTTP status code 200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Request was successful
                System.out.println("Run value updated successfully.");
            } else {
                // Request failed
                System.err.println("Failed to update run value. Response code: " + responseCode);
            }

            // Close the connection
            conn.disconnect();
        } catch (Exception e) {
            // Exception occurred
            e.printStackTrace();
        }
    }

  
}

