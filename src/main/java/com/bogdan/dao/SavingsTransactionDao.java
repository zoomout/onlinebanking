package com.bogdan.dao;

import com.bogdan.domain.SavingsTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by zoomout on 12/31/16.
 */
public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}
