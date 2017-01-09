package com.bogdan.service;

import com.bogdan.domain.Customer;
import com.bogdan.domain.security.UserRole;

import java.util.Set;

/**
 * Created by zoomout on 12/25/16.
 */
public interface UserService {

    Customer findByUsername(String username);

    Customer findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    void save(Customer customer);

    Customer createUser(Customer customer, Set<UserRole> userRoles);
}
