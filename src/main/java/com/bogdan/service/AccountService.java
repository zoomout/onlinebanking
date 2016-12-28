package com.bogdan.service;

import com.bogdan.domain.PrimaryAccount;
import com.bogdan.domain.SavingsAccount;

/**
 * Created by zoomout on 12/27/16.
 */
public interface AccountService {
    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
}
