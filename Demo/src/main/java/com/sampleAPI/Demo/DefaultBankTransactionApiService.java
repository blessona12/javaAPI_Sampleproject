package com.sampleAPI.Demo;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class DefaultBankTransactionApiService implements BankTransactionApiService {

    private final ApiClient apiClient;

    public DefaultBankTransactionApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public List<Transaction> getTransactions() throws Exception {
        String apiUrl = ""; //url to validate
        String responseJson = apiClient.makeGetRequest(apiUrl);

        
        Type transactionListType = new TypeToken<List<Transaction>>() {}.getType();
        return new Gson().fromJson(responseJson, transactionListType);
    }
}
