package com.bogdan.service;

import com.bogdan.domain.User;
import com.bogdan.domain.security.UserRole;

import java.util.Set;

/**
 * Created by zoomout on 12/25/16.
 */
public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    void save(User user);

    User saveUser(User user);

    User createUser(User user, Set<UserRole> userRoles);
}
