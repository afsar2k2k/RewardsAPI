package com.innova.rewards.model;

import java.time.LocalDate;

public class CustomerPurchaseInfo {

    private String customerId;
    private double purchaseAmount;
    private LocalDate purchaseDate;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public CustomerPurchaseInfo() {
    }

    public CustomerPurchaseInfo(String customerId, double purchaseAmount, LocalDate purchaseDate) {
        this.customerId = customerId;
        this.purchaseAmount = purchaseAmount;
        this.purchaseDate = purchaseDate;
    }
}
