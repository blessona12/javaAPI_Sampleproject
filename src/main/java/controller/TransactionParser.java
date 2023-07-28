package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TransactionParser {
    public static List<Transaction> parse(String apiResponse) {
        Gson gson = new Gson();
        Type transactionListType = new TypeToken<List<Transaction>>() {}.getType();

        // Assuming the API response is an array of JSON objects representing transactions
        List<Transaction> transactions = gson.fromJson(apiResponse, transactionListType);

        return transactions;
    }
}
