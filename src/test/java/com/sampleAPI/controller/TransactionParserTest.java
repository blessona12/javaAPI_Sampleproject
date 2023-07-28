package com.sampleAPI.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;


import controller.TransactionParser;
import controller.Transaction;

public class TransactionParserTest {

    @org.junit.jupiter.api.Test
    public void testParse() {
        // Given
        String apiResponse = "[{\"amount\": 100.0, \"date\": \"2023-07-17\"}, {\"amount\": 200.0, \"date\": \"2023-07-18\"}]";

        // When
        List<Transaction> transactions = TransactionParser.parse(apiResponse);

        // Then
        assertEquals(2, transactions.size());
        assertEquals(100.0, transactions.get(0).getAmount(), 0.001);
        assertEquals("2023-07-17", transactions.get(0).getDate());
        assertEquals(200.0, transactions.get(1).getAmount(), 0.001);
        assertEquals("2023-07-18", transactions.get(1).getDate());
    }
}



