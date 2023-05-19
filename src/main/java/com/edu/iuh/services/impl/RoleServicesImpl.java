package com.edu.iuh.services.impl;

import com.edu.iuh.repositories.RoleRepository;
import com.edu.iuh.entities.Role;
import com.edu.iuh.services.RoleServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServicesImpl implements RoleServices {
    private final RoleRepository roleRepository;

    public RoleServicesImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findOneById(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role deleteById(String id) {
        Role role = findOneById(id);
        roleRepository.deleteById(id);
        return role;
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findRoleByRoleNameIgnoreCase(String roleName) {
        return roleRepository.findRoleByRoleNameIgnoreCase(roleName);
    }

    @Override
    public List<Role> findRolesBy() {
        return roleRepository.findRolesBy();
    }
}