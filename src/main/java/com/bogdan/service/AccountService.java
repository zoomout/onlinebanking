package com.bogdan.service;

import com.bogdan.domain.PrimaryAccount;
import com.bogdan.domain.SavingsAccount;

import java.security.Principal;

/**
 * Created by zoomout on 12/27/16.
 */
public interface AccountService {
    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();

    void deposit(String accountType, double amount, Principal principal);
    void withdraw(String accountType, double amount, Principal principal);
}
