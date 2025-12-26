package com.lvicentea.store.repositories;

import com.lvicentea.store.entities.Role;
import com.lvicentea.store.enums.RoleList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(RoleList name);

}
