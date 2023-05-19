package com.luongvandat.services;

import com.luongvandat.entities.Role;

import java.util.List;

public interface RoleServices {
    Role findOneById(String id);

    Role add(Role role);

    Role deleteById(String id);

    Role update(Role role);

    Role findRoleByRoleNameIgnoreCase(String roleName);
    List<Role> findRolesBy();
}