package com.sampleAPI.Demo;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import controller.BankTransactionsAPIClient;
import controller.Transaction;

@SpringBootApplication
public class DemoApplication {

	 public static void main(String[] args) {
	        BankTransactionsAPIClient apiClient = new BankTransactionsAPIClient();

	        try {
	            List<Transaction> transactions = apiClient.getTransactionsForCustomer("customer123");

	            // Display the transactions
	            for (Transaction transaction : transactions) {
	                System.out.println("Amount: " + transaction.getAmount() + ", Date: " + transaction.getDate());
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
