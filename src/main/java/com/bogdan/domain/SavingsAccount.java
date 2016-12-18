package com.bogdan.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zoomout on 12/18/16.
 */
public class SavingsAccount {
    private Long id;
    private int accountNumber;
    private BigDecimal accountBalance;
    private List<SavingsTransaction> savingsTransactionList;

    @Override
    public String toString() {
        return "SavingsAccount{" + "id=" + id + ", accountNumber=" + accountNumber
            + ", accountBalance=" + accountBalance + ", savingsTransactionList="
            + savingsTransactionList + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<SavingsTransaction> getSavingsTransactionList() {
        return savingsTransactionList;
    }

    public void setSavingsTransactionList(List<SavingsTransaction> SavingsTransactionList) {
        this.savingsTransactionList = SavingsTransactionList;
    }
}
