package com.bogdan.service;

import com.bogdan.dao.UserDao;
import com.bogdan.domain.Customer;
import com.bogdan.domain.security.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by zoomout on 12/25/16.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AccountService accountService;

    public void save(Customer customer) {
        userDao.save(customer);
    }

    public Customer createUser(Customer customer, Set<UserRole> userRoles) {
        Customer localCustomer = userDao.findByUsername(customer.getUsername());

        if (localCustomer != null) {
            LOG.info("Customer with username {} already exist. Nothing will be done. ", customer.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(encryptedPassword);

//            for (UserRole ur : userRoles) {
//                roleDao.save(ur.getRole());
//            }

            customer.getUserRoles().addAll(userRoles);

            customer.setPrimaryAccount(accountService.createPrimaryAccount());
            customer.setSavingsAccount(accountService.createSavingsAccount());

            localCustomer = userDao.save(customer);
        }

        return localCustomer;
    }

    public Customer findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public Customer findByEmail(String email) {
        return userDao.findByEmail(email);
    }


    public boolean checkUserExists(String username, String email) {
        return checkUsernameExists(username) || checkEmailExists(email);
    }

    public boolean checkUsernameExists(String username) {
        return null != findByUsername(username);
    }

    public boolean checkEmailExists(String email) {
        return null != findByEmail(email);
    }

}
