package com.bogdan.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zoomout on 12/18/16.
 */
public class PrimaryAccount {
    private Long id;
    private int accountNumber;
    private BigDecimal accountBalance;
    private List<PrimaryTransaction> primaryTransactionList;

    @Override
    public String toString() {
        return "PrimaryAccount{" + "id=" + id + ", accountNumber=" + accountNumber
            + ", accountBalance=" + accountBalance + ", primaryTransactionList="
            + primaryTransactionList + '}';
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

    public List<PrimaryTransaction> getPrimaryTransactionList() {
        return primaryTransactionList;
    }

    public void setPrimaryTransactionList(List<PrimaryTransaction> primaryTransactionList) {
        this.primaryTransactionList = primaryTransactionList;
    }
}
