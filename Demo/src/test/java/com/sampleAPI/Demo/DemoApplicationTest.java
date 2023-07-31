package com.sampleAPI.Demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;


public class DemoApplicationTest {

    @Test
    public void testFetchBankTransactions() throws Exception {
        BankTransactionApiService mockApiService = mock(BankTransactionApiService.class);

        List<Transaction> expectedTransactions = Arrays.asList(
            new Transaction(100.0, "2023-07-31"),
            new Transaction(200.0, "2023-07-30")
        );
        when(mockApiService.getTransactions()).thenReturn(expectedTransactions);

        DemoApplication mainApp = new DemoApplication(mockApiService);

        List<Transaction> transactions = mainApp.fetchBankTransactions();

        assertEquals(expectedTransactions, transactions);
    }
}

