package com.bogdan.service;

import com.bogdan.dao.RoleDao;
import com.bogdan.domain.security.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zoomout on 12/25/16.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RoleDao roleDao;


    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }
}
