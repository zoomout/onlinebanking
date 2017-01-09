package com.bogdan.service;

import com.bogdan.dao.PrimaryTransactionDao;
import com.bogdan.dao.SavingsTransactionDao;
import com.bogdan.domain.Customer;
import com.bogdan.domain.PrimaryTransaction;
import com.bogdan.domain.SavingsTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private PrimaryTransactionDao primaryTransactionDao;

    @Autowired
    private SavingsTransactionDao savingsTransactionDao;

    public List<PrimaryTransaction> findPrimaryTransactionList(String username) {
        Customer customer = userService.findByUsername(username);

        return customer.getPrimaryAccount().getPrimaryTransactionList();
    }

    public List<SavingsTransaction> findSavingsTransactionList(String username) {
        Customer customer = userService.findByUsername(username);

        return customer.getSavingsAccount().getSavingsTransactionList();
    }

    public void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction) {
        primaryTransactionDao.save(primaryTransaction);
    }

    public void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction) {
        savingsTransactionDao.save(savingsTransaction);
    }

    public void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction) {
        primaryTransactionDao.save(primaryTransaction);
    }

    public void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction) {
        savingsTransactionDao.save(savingsTransaction);
    }
}
