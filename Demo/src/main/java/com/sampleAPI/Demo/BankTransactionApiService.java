package com.sampleAPI.Demo;

import java.util.List;

public interface BankTransactionApiService {
    List<Transaction> getTransactions() throws Exception;
}
