package com.bogdan.dao;

import com.bogdan.domain.PrimaryTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by zoomout on 12/31/16.
 */
public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}
