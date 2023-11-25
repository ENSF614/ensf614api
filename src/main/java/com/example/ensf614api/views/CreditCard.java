package com.example.ensf614api.views;

public class CreditCard {
	
	private String cardNumber;
	private String cardExpiry;
	private String cardCVV;
	
	public CreditCard(String cardNumber, String cardExpiry, String cardCVV) {
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cardCVV = cardCVV;
	}

	// Getter for cardNumber
    public String getCardNumber() {
        return cardNumber;
    }

    // Setter for cardNumber
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // Getter for cardExpiry
    public String getCardExpiry() {
        return cardExpiry;
    }

    // Setter for cardExpiry
    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    // Getter for cardCVV
    public String getCardCVV() {
        return cardCVV;
    }

    // Setter for cardCVV
    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }
}
