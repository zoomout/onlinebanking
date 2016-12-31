package com.bogdan.service;

import com.bogdan.dao.PrimaryAccountDao;
import com.bogdan.dao.SavingsAccountDao;
import com.bogdan.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

/**
 * Created by zoomout on 12/27/16.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static int nextAccountNumber = 11223145;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

    @Autowired
    private UserService userService;

    private int accountGen() {
        return ++nextAccountNumber;
    }

    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountDao.save(primaryAccount);

        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    public SavingsAccount createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        savingsAccountDao.save(savingsAccount);

        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
    }

    public void deposit(String accountType, double amount, Principal principal) {
        changeAmount(accountType, amount, principal, true);

    }

    public void withdraw(String accountType, double amount, Principal principal) {
        changeAmount(accountType, amount, principal, false);
    }

    private void changeAmount(String accountType, double amount, Principal principal,
      boolean positive) {
        User user = userService.findByUsername(principal.getName());

        if (accountType.equalsIgnoreCase("Primary")) {
            PrimaryAccount primaryAccount = user.getPrimaryAccount();

            BigDecimal accountBalance = primaryAccount.getAccountBalance();
            if (positive) {
                accountBalance.add(new BigDecimal(amount));
            } else {
                accountBalance.subtract(new BigDecimal(amount));
            }
            primaryAccount.setAccountBalance(accountBalance.subtract(new BigDecimal(amount)));
            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction =
              new PrimaryTransaction(date, "Deposit to Primary Account", "Account", "Finished",
                amount, accountBalance, primaryAccount);
            //            transactionService.savePrimaryDepositTransaction(primaryTransaction);

        } else if (accountType.equalsIgnoreCase("Savings")) {
            SavingsAccount savingsAccount = user.getSavingsAccount();
            savingsAccount.setAccountBalance(
              savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();
            SavingsTransaction savingsTransaction =
              new SavingsTransaction(date, "Deposit to savings Account", "Account", "Finished",
                amount, savingsAccount.getAccountBalance(), savingsAccount);
            //            transactionService.saveSavingsDepositTransaction(savingsTransaction);
        }
    }

}
