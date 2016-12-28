package com.bogdan.dao;


import com.bogdan.domain.SavingsAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zoomout on 10/21/16.
 */
public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber(int accountNumber);
}
