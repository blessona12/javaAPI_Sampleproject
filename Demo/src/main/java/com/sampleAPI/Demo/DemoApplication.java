package com.sampleAPI.Demo;

import java.util.List;

public class DemoApplication {

    private final BankTransactionApiService apiService;

    public DemoApplication(BankTransactionApiService apiService) {
        this.apiService = apiService;
    }

    public List<Transaction> fetchBankTransactions() throws Exception {
        return apiService.getTransactions();
    }

    public static void main(String[] args) {
        ApiClient apiClient = new DefaultApiClient();
        BankTransactionApiService apiService = new DefaultBankTransactionApiService(apiClient);
        DemoApplication mainApp = new DemoApplication(apiService);

        try {
            List<Transaction> transactions = mainApp.fetchBankTransactions();
            for (Transaction transaction : transactions) {
                System.out.println("Amount: " + transaction.getAmount() + ", Date: " + transaction.getDate());
            }
        } catch (Exception e) {
            System.err.println("Error during API call: " + e.getMessage());
        }
    }
}

