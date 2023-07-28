package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BankTransactionsAPIClient {
    private static final String API_BASE_URL = "https://sampleAPI.com/transactions"; // Replace with actual API URL

    public List<Transaction> getTransactionsForCustomer(String customerId) throws IOException {
        String apiUrl = API_BASE_URL + "?customer=" + customerId;
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the API response and return the list of transactions
            return TransactionParser.parse(response.toString());
        } else {
            throw new IOException("Error retrieving transactions. HTTP error code: " + responseCode);
        }
    }
}
