package com.bogdan.service;

import com.bogdan.dao.UserDao;
import com.bogdan.domain.User;
import com.bogdan.domain.security.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userDao.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            user.getUserRoles().addAll(userRoles);

            user.setPrimaryAccount(accountService.createPrimaryAccount());
            user.setSavingsAccount(accountService.createSavingsAccount());

            localUser = userDao.save(user);
        }

        return localUser;
    }

    @Override
    public List<User> findUserList() {
        return userDao.findAll();
    }

    @Override
    public void enableUser(String username) {
        User user = findByUsername(username);
        user.setEnabled(true);
        userDao.save(user);
    }

    @Override
    public void disableUser(String username) {
        User user = findByUsername(username);
        user.setEnabled(false);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public boolean checkUserExists(String username, String email) {
        return checkUsernameExists(username) || checkEmailExists(email);
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return null != findByUsername(username);
    }

    @Override
    public boolean checkEmailExists(String email) {
        return null != findByEmail(email);
    }

}
