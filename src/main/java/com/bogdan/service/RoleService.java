package com.bogdan.service;

import com.bogdan.domain.security.Role;

/**
 * Created by zoomout on 12/25/16.
 */
public interface RoleService {

    void save(Role Role);

    Role findByName(String name);
}
