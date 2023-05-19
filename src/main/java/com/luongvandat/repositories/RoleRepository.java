package com.luongvandat.repositories;

import com.luongvandat.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(origins = "*")
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findRoleByRoleNameIgnoreCase(String roleName);
    List<Role> findRolesBy();
}