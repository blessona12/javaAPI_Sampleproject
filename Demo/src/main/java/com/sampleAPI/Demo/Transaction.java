package com.sampleAPI.Demo;


public class Transaction {
    private double amount;
    private String date;

    public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Transaction(double amount, String date) {
        this.amount = amount;
        this.date = date;
    }

}


