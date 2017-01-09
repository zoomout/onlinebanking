package com.bogdan.dao;

import com.bogdan.domain.Customer;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by zoomout on 12/25/16.
 */
public interface UserDao extends CrudRepository<Customer, Long> {
    Customer findByUsername(String username);
    Customer findByEmail(String email);

}
