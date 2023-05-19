package com.edu.iuh.services;

import com.edu.iuh.entities.Role;

import java.util.List;

public interface RoleServices {
    Role findOneById(String id);

    Role add(Role role);

    Role deleteById(String id);

    Role update(Role role);

    Role findRoleByRoleNameIgnoreCase(String roleName);
    List<Role> findRolesBy();
}