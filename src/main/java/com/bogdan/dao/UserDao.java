package com.bogdan.dao;

import com.bogdan.domain.User;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by zoomout on 12/25/16.
 */
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);

}
