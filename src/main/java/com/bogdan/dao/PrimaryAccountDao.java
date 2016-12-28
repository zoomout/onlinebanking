package com.bogdan.dao;


import com.bogdan.domain.PrimaryAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zoomout on 10/21/16.
 */
public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber(int accountNumber);
}
