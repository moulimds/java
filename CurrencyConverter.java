import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");

        // Currency selection
        System.out.print("Enter the base currency code (e.g., USD, EUR): ");
        String baseCurrency = scanner.next().toUpperCase();
        System.out.print("Enter the target currency code (e.g., USD, EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Amount input
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Fetch exchange rate
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        // Currency conversion
        double convertedAmount = amount * exchangeRate;

        // Display result
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }

    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject rates = jsonObject.getJSONObject("rates");
            double exchangeRate = rates.getDouble(targetCurrency);

            return exchangeRate;
        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
            return -1; // Return -1 if error occurs
        }
    }
}