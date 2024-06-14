import java.util.Scanner;

public class currencyconverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Supported currencies (modify as needed)
        String[] currencies = {"USD", "EUR", "JPY", "GBP"};

        // Get user selection for base and target currencies
        String baseCurrency = selectCurrency(scanner, currencies, "Select base currency: ");
        String targetCurrency = selectCurrency(scanner, currencies, "Select target currency: ");

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);

        double convertedAmount = amount * exchangeRate;

        System.out.printf("%.2f %s is equal to %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }

    private static String selectCurrency(Scanner scanner, String[] options, String prompt) {
        System.out.println(prompt);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        while (true) {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice > 0 && choice <= options.length) {
                return options[choice - 1];
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static double fetchExchangeRate(String baseCurrency, String targetCurrency) {
        System.out.println("Fetching live exchange rate...");
        return Math.random() * 2;
    }
}